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
    private ContaEspecial[] contasEspeciais = new ContaEspecial[100];
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

        ContaEspecial cEspecial = new ContaEspecial(0, cliente.getCpf(), cliente.getNumero());
        contasEspeciais[pos] = cEspecial;

        Conta conta = new Conta(0, cliente.getCpf(), cliente.getNumero());
        contas[pos] = conta;
    }

// Método de realizar saque
    public void saque() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Em que conta deseja sacar; \n"
                    + "1 - Conta especial\n"
                    + "2 - Conta Comum");
            int tipoConta = sc.nextInt();

            System.out.println("Qual o número da conta: ");
            int n = sc.nextInt();
            System.out.println("Qual valor deseja sacar? ");
            int s = sc.nextInt();

            if (tipoConta == 1) {
                contasEspeciais[n].saque(s);
            } else if (tipoConta == 2) {

                contas[n].saque(s);
            }

        }
    }

    // Método de realizar depósitos
    public void deposito() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Em que conta deseja sacar; \n"
                    + "1 - Conta especial\n"
                    + "2 - Conta Comum");
            int tipoConta = sc.nextInt();

            System.out.println("Qual o número da conta: ");
            int n = sc.nextInt();
            System.out.println("Qual valor deseja depositar? ");
            int s = sc.nextInt();

            if (tipoConta == 1) {
                contasEspeciais[n].deposito(s);
            } else if (tipoConta == 2) {

                contas[n].deposito(s);
            }

        }
    }

    // Método de realizar transferencia entre contas
    public void transferencia() {
        if (pos < 1) {
            System.out.println("Operação inválida! Conta não existente!");
        } else {
            System.out.println("Tipo de conta para saque: \n"
                    + "1 - Conta especial\n"
                    + "2 - Conta Comum");
            int tipoContaSaque = sc.nextInt();

            System.out.println("Digite o número de sua conta: ");
            int nusuario = sc.nextInt();

            System.out.println("\n\n Tipo de Conta depósito: \n"
                    + "1 - Conta especial\n"
                    + "2 - Conta Comum");
            int tipoContaDestino = sc.nextInt();

            System.out.println("Digite o número da conta favorecida: ");
            int nfavorecido = sc.nextInt();
            System.out.println("Digite o valor a ser transferido: ");
            int s = sc.nextInt();

            if (tipoContaSaque == 1) {
                if (tipoContaDestino == 1) {
                    contasEspeciais[nusuario].saque(s);
                    contasEspeciais[nfavorecido].deposito(s);
                } else if (tipoContaDestino == 2) {
                    contasEspeciais[nusuario].saque(s);
                    contas[nfavorecido].deposito(s);
                }
            } else if (tipoContaDestino == 2) {

                if (tipoContaDestino == 1) {
                    contas[nusuario].saque(s);
                    contasEspeciais[nfavorecido].deposito(s);
                } else if (tipoContaDestino == 2) {
                    contas[nusuario].saque(s);
                    contas[nfavorecido].deposito(s);
                }

            }
        }
    }

    // Método adicional para consultar clientes e contas
    public void consultarClientes() {
        for (int i = 1; i <= pos; i++) {
            Cliente c = new Cliente(pos);
            String nome = clientes[i].getNome();
            String cpf = clientes[i].getCpf();
            int nConta = clientes[i].getNumero();
            double saldoConta = contas[i].getSaldo();
            double saldoContaEspecial = contasEspeciais[i].getSaldo();

            System.out.println("\nCliente: " + nome + ", cpf: " + cpf + ", Número de conta: " + nConta + ", Conta comum saldo: " + saldoConta + " R$" + ", Conta especial: " + saldoContaEspecial + " R$" + "\n");
        }
    }

}
