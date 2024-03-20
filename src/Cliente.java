public class Cliente {
    private String nome;
    private String cpf;
    private double saldo;

    public Cliente(String nome, String cpf) throws Exception {
        if(!validarCPF(cpf)){
            throw new Exception("CPF invalido");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = 0;
    }

    public void realizarDeposito(double valor) {
        this.saldo += valor;
    }

    public void realizarSaque(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    private boolean validarCPF(String cpf){
        //Remover caracter especial
        cpf = cpf.replaceAll("[^0-9]", "");

        //Verificar se tem 11 digitos
        if(cpf.length() != 11){
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}"))
            return false;

           // Calcular os dígitos verificadores
        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Character.getNumericValue(cpf.charAt(i));
        }

        int soma = 0;
        int resto;

        // Calcular o primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * (10 - i);
        }
        resto = soma % 11;
        int dv1 = resto < 2 ? 0 : 11 - resto;
        if (dv1 != digitos[9])
            return false;

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * (11 - i);
        }
        resto = soma % 11;
        int dv2 = resto < 2 ? 0 : 11 - resto;
        if (dv2 != digitos[10])
            return false;

        return true;
    }

    public String getNome() {
        return this.nome;
    }
}
