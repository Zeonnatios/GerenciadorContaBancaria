package sistemabancario;

public class ContaEspecial extends Conta {

    public ContaEspecial(int valor, String cpf, int numero) {
        super(valor, cpf, numero);
    }

    @Override
    public void saque(double valor) {
        double t = saldo - valor;
        if (saldo >= valor || t >= -1000) {
            this.saldo = saldo - valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: " + saldo + " R$");
        } else {
            System.out.println("Saldo insuficiente! Faça depósito");
        }
    }

}
