/*
 * 1 - GerenciadorContaBancaria: esta classe deverá também ser o nome do projeto. Ela
 * será usada para iniciar a execução do sistema
 */
package sistemabancario;

import java.util.Scanner;

/**
 *
 * @author Matheus Antonio
 */
public class GerenciadorContaBancaria {

    static Scanner sc = new Scanner(System.in);
    private static Banco banco = new Banco();

    // menu com entrada de dados
    static int menuOpcoes() {
        System.out.println("Escolha a opção desejada:"
                + "\n1 - Cadastrar conta"
                + "\n2 - Sacar"
                + "\n3 - Depositar"
                + "\n4 - Transferência"
                + "\n5 - Consultar clientes"
                + "\n6 - Sair do sistema");
        int opcao = sc.nextInt();
        return opcao;
    }

    public static void main(String[] args) {

        // looping do menu
        boolean sair = false;
        while (!sair) {
            switch (menuOpcoes()) {
                case 1:
                    banco.cadastro();
                    break;
                case 2:
                    banco.saque();
                    break;
                case 3:
                    banco.deposito();
                    break;
                case 4:
                    banco.transferencia();
                    break;
                case 5:
                    banco.consultarClientes();
                    break;
                case 6:
                    sair = true;
                default:
                    System.out.println("\nOpção inválida!\n");
            }
        }
    }
}
