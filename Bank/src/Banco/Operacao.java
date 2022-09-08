package Banco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Operacao {
    
    private ArrayList<Operacao> alOperacoes;
    private LocalDate data;
    private float valor;
    protected int opt;
    private TipoOperacao tipo;
	
	//final static int SAQUE = 1;
	//final static int DEPOSITO = 2;

    public Operacao(LocalDate data, float valor, TipoOperacao tipo){
        super();
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Operacao() {
		super();
		this.alOperacoes = new ArrayList<Operacao>();
	}
	public ArrayList<Operacao> getListaOperacoes() {
		return alOperacoes;
	}

    public void saque(){
        
    }
    public void deposito(){

    }
}
