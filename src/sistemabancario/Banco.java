/*
 * 2 - Banco: deverá conter os métodos para o gerenciamento da conta, bem como armazenar as
 * informações de contas e clientes
 */
package sistemabancario;

import java.util.Scanner;

/**
 *
 * @author Matheus Antonio
 */
public class Banco {

    static Scanner sc = new Scanner(System.in);
    private final int codigo = 1; //- armazena o código do banco
    private Cliente[] clientes = new Cliente[100]; //vetor de objetos clientes
    private Conta[] contas = new Conta[100]; //vetor de objetos contas bancáreas
    private int pos = 0;

    public Banco() {
        //construtor
    }

    // Método cadastrar cliente e conta nova
    public void cadastro() {
        pos++;
        Cliente cliente = new Cliente(pos);
        cliente.cadastroCliente();
        clientes[pos] = cliente;
        Conta conta = new Conta(0, cliente.getCpf(), cliente.getNumero());
        contas[pos] = conta;
    }

    // Método de realizar saque
    public void saque() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Qual o número da conta: ");
            int n = sc.nextInt();
            System.out.println("Qual valor deseja sacar? ");
            int s = sc.nextInt();
            contas[n].saque(s);
        }
    }

    // Método de realizar depósitos
    public void deposito() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Qual o número da conta: ");
            int n = sc.nextInt();
            System.out.println("Qual valor deseja sacar? ");
            int s = sc.nextInt();
            contas[n].deposito(s);
        }
    }

    // Método de realizar transferencia entre contas
    public void transferencia() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Digite o número de sua conta: ");
            int nusuario = sc.nextInt();
            System.out.println("Digite o número da conta favorecida: ");
            int nfavorecido = sc.nextInt();
            System.out.println("Digite o valor a ser transferido: ");
            int s = sc.nextInt();
            contas[nusuario].saque(s);
            contas[nfavorecido].deposito(s);
        }
    }

    // Método adicional para consultar clientes e contas
    public void consultarClientes() {
        for (int i = 1; i <= pos; i++) {
            String nome = clientes[i].getNome();
            String cpf = clientes[i].getCpf();
            int conta = contas[i].getNumero();
            double saldo = contas[i].getSaldo();
            System.out.println("\nCliente: " + nome + ", cpf: " + cpf + ", Número de conta: " + conta + ", saldo: " + saldo + "\n");
        }
    }

}
