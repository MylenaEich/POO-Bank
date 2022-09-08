package Banco;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> alContas;

    public Banco() {
		super();
		this.alContas = new ArrayList<Conta>();
	}
	public ArrayList<Conta> getContas() {
		return alContas;
	}
    public void addConta(Conta conta){
        alContas.add(conta);
    }

    public void addContaPix(int numConta, String nome, String CPF){
        Conta conta = new Conta(numConta, nome, CPF);
		alContas.add(conta);
    }
    public void addConta(int numConta, String nome){
        Conta conta = new Conta(numConta, nome);
		alContas.add(conta);
    }

}
