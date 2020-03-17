/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabancario;

/**
 *
 * @author Matheus Antonio
 */
public class Conta {

    private int numero;
    private double saldo;
    private String cpf;

    public Conta(int valor, String cpf, int numero) {
        //construtor
        this.saldo = valor;
        this.cpf = cpf;
        this.numero = numero;
    }

    public boolean saque(double saque) {
        boolean sacou = false;
        if (this.saldo >= saque) {
            this.saldo = this.saldo - saque;
            System.out.println("Saque realizado com sucesso!");
            sacou = true;
        } else {
            System.out.println("Saldo insuficiente!");
        }
        return sacou;
    }

    public boolean deposito(double valor) {
        boolean depositou = false;
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            System.out.println("Depósito realizado com sucesso!");
            depositou = true;
        } else {
            System.out.println("Depósito não efetuado!");
        }
        return depositou;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
