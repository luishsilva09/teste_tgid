public class SistemaTransacao {
    public static void main(String[] args) throws Exception {
                Cliente cliente1 = new Cliente("Fulano", "123.456.789-10");
                Empresa empresa1 = new Empresa("Empresa A", "12.345.678/0001-90", 5);
        
                cliente1.realizarDeposito(100);
                System.out.println("Saldo do cliente: " + cliente1.getSaldo());
        
                empresa1.realizarDepositoCliente(cliente1, 50);
                System.out.println("Saldo da empresa: " + empresa1.getSaldo());
                System.out.println("Saldo do cliente após depósito: " + cliente1.getSaldo());
        
                empresa1.realizarSaqueCliente(cliente1, 30);
                System.out.println("Saldo da empresa: " + empresa1.getSaldo());
                System.out.println("Saldo do cliente após saque: " + cliente1.getSaldo());
            }
}
