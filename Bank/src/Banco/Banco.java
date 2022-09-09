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

}
