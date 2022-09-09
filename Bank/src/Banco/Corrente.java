package Banco;

import Interfaces.Pix;
import java.util.ArrayList;

public class Corrente extends Conta implements Pix{

    private ArrayList<Conta> alContas;

    public Corrente(int numConta, float saldo, String nome, String CPF){
        super(numConta, saldo, nome, CPF);
    }
    public Corrente(int numConta, String nome, String CPF){
        super(numConta, nome, CPF);
    }
    public Corrente(int numConta, float saldo,String nome){
        super(numConta, saldo, nome);
    }
    public Corrente(int numConta, String nome){
        super(numConta, nome);
    }
    public void addConta(Corrente corrente){
        alContas.add(corrente);
    }
    public void setNumConta(int numConta){
        setNumConta(numConta);
    }

    public void addCCPix(String nome, String CPF){
        int numConta = alContas.size() + 1;
        Corrente corrente = new Corrente(numConta, nome, CPF);
		addConta(corrente);
    }
    public void addCC( String nome){
        int numConta = alContas.size() + 1;
        Corrente corrente = new Corrente(numConta,  nome);
        addConta(corrente);
    }
}