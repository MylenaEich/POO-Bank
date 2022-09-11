package Banco;

import Interfaces.*;
import java.util.ArrayList;

public class Poupanca extends Conta implements Remunerada {

    private ArrayList<Conta> alContas;
    private static Banco banco = new Banco();

    public Poupanca(int numConta, float saldo, String nome, String CPF){
        super(numConta, saldo, nome, CPF);
    }
    public Poupanca(int numConta, String nome, String CPF){
        super(numConta, nome, CPF);
    }
    public Poupanca(int numConta, float saldo, String nome){
        super(numConta, saldo, nome);
    }
    public Poupanca(int numConta, String nome){
        super(numConta, nome);
    }
    public void addConta(Poupanca poupanca){
        alContas.add(poupanca);
    }
    // public void addCPPix( String nome, String CPF){
    //     int numConta = alContas.size() + 1;
    //     Poupanca poupanca = new Poupanca(numConta, nome, CPF);
	// 	addConta(poupanca);
    // }
    public void addCP(int numConta, String nome){
        Poupanca poupanca = new Poupanca(numConta, nome);
        addConta(poupanca);
    }
}