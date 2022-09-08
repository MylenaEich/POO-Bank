package Banco;

import Interfaces.*;
import java.util.ArrayList;

public class Poupanca extends Conta implements Remunerada {

    private ArrayList<Conta> alContas;

    public Poupanca(int numConta, String nome, String CPF){
        super(numConta, nome, CPF);
    }
    public Poupanca(int numConta, String nome){
        super(numConta, nome);
    }
    public void addConta(Poupanca poupanca){
        alContas.add(poupanca);
    }
    public void addContaPix(int numConta, String nome, String CPF){
        Poupanca poupanca = new Poupanca(numConta, nome, CPF);
		addConta(poupanca);
    }
    public void addConta(int numConta, String nome){
        Poupanca poupanca = new Poupanca(numConta, nome);
        addConta(poupanca);
    }
}