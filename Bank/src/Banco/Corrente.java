package Banco;

import Interfaces.Pix;
import java.util.ArrayList;

public class Corrente extends Conta implements Pix{

    private ArrayList<Conta> alContas;

    public Corrente(int numConta, String nome, String CPF){
        super(numConta, nome, CPF);
    }
    public Corrente(int numConta, String nome){
        super(numConta, nome);
    }
    public void addConta(Corrente corrente){
        alContas.add(corrente);
    }
    public void addContaPix(int numConta, String nome, String CPF){
        Corrente corrente = new Corrente(numConta, nome, CPF);
		addConta(corrente);
    }
    public void addConta(int numConta, String nome){
        Corrente corrente = new Corrente(numConta, nome);
        addConta(corrente);
    }
}