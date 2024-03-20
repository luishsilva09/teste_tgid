public class Empresa {
        private String nome;
        private String cnpj;
        private double saldo;
        private double taxaSistema;
    
        public Empresa(String nome, String cnpj, double taxaSistema) throws Exception {
            if(!validarCNPJ(cnpj)){
                throw new Exception("CNPJ invalido");
            }
            this.nome = nome;
            this.cnpj = cnpj;
            this.saldo = 0;
            this.taxaSistema = taxaSistema;
        }
    
        public void realizarDepositoCliente(Cliente cliente, double valor) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                cliente.realizarDeposito(valor);
                this.saldo -= taxaSistema;
                enviarCallback("Depósito realizado");
                notificarCliente(cliente, "Depósito de " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo da empresa insuficiente.");
            }
        }
    
        public void realizarSaqueCliente(Cliente cliente, double valor) {
            if (cliente.getSaldo() >= valor) {
                cliente.realizarSaque(valor);
                this.saldo += valor;
                this.saldo -= taxaSistema;
                enviarCallback("Saque realizado");
                notificarCliente(cliente, "Saque de " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Saldo do cliente insuficiente.");
            }
        }
        public static boolean validarCNPJ(String cnpj) {
            // Remover caracteres especiais e espaços em branco
            cnpj = cnpj.replaceAll("[^0-9]", "");
    
            // Verificar se o CNPJ tem 14 dígitos
            if (cnpj.length() != 14)
                return false;
    
            // Calcular os dígitos verificadores
            int[] digitos = new int[14];
            for (int i = 0; i < 14; i++) {
                digitos[i] = Character.getNumericValue(cnpj.charAt(i));
            }
    
            int soma = 0;
            int resto;
            int multiplicador = 2;
    
            // Calcular o primeiro dígito verificador
            for (int i = 11; i >= 0; i--) {
                soma += digitos[i] * multiplicador;
                multiplicador++;
                if (multiplicador == 10) multiplicador = 2;
            }
            resto = soma % 11;
            int dv1 = resto < 2 ? 0 : 11 - resto;
            if (dv1 != digitos[12])
                return false;
    
            // Calcular o segundo dígito verificador
            soma = 0;
            multiplicador = 2;
            for (int i = 12; i >= 0; i--) {
                soma += digitos[i] * multiplicador;
                multiplicador++;
                if (multiplicador == 10) multiplicador = 2;
            }
            resto = soma % 11;
            int dv2 = resto < 2 ? 0 : 11 - resto;
            if (dv2 != digitos[13])
                return false;
    
            return true;
        }
    
        private void notificarCliente(Cliente cliente, String mensagem) {
            // Lógica para notificar o cliente por e-mail, SMS, etc.
            System.out.println("Notificando cliente " + cliente.getNome() + " - " + mensagem);
        }
    
        private void enviarCallback(String mensagem) {
            // Lógica para enviar o callback para a empresa
            System.out.println("Callback enviado para empresa " + nome + " - " + mensagem);
        }

        public double getSaldo() {
            return this.saldo;
        }
    }
