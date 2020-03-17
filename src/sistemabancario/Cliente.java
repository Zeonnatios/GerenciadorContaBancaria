/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

import java.util.Scanner;

/**
 *
 * @author Matheus Antonio
 */
public class Cliente {

    static Scanner sc = new Scanner(System.in);
    private String nome;
    private String cpf;
    private int numero;

    public Cliente(int conta) {
        //construtor
        this.numero = conta;
    }

    // Método para cadastrar cliente
    public void cadastroCliente() {
        System.out.println("Digite o nome do cliente: ");
        this.nome = sc.next();
        System.out.println("Digite o cpf do cliente: ");
        this.cpf = sc.next();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getNumero() {
        return numero;
    }

}
