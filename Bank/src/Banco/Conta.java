package Banco;

import java.util.ArrayList;

public abstract class Conta {

    private int numConta;
    private float saldo;
    private String nome;
    private String CPF;
    private ArrayList<Conta> alContas;

    public Conta(int numConta, float saldo, String nome, String CPF){
        super();
        this.numConta = numConta;
        this.saldo = saldo;
        this.nome = nome;
        this.CPF = CPF;
    }
    public Conta(int numConta, String nome, String CPF){
        super();
        this.numConta = numConta;
        this.saldo = 0;
        this.nome = nome;
        this.CPF = CPF;
    }
    public Conta(int numConta, float saldo, String nome){
        super();
        this.numConta = numConta;
        this.saldo = saldo;
        this.nome = nome;
        this.CPF = null;
    }
    public Conta(int numConta, String nome){
        super();
        this.numConta = numConta;
        this.saldo = 0;
        this.nome = nome;
        this.CPF = null;
    }
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    public int getNumConta(){
        return numConta;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public String getCPF(){
        return CPF;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public float getsaldo(){
        return saldo;
    }
    public void deposito(float valor){
        this.saldo = this.saldo + valor;
    }
    public void saque(float valor){
        this.saldo = this.saldo - valor;
    }
}