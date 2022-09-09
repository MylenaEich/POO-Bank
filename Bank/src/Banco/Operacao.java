package Banco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Operacao {
    
    private ArrayList<Operacao> alOperacoes;
    private LocalDate data;
    private float valor;
    private int numConta;
    protected int opt;
    private TipoOperacao tipo;
	
	//final static int SAQUE = 1;
	//final static int DEPOSITO = 2;

    public Operacao(LocalDate data, float valor, int numConta, TipoOperacao tipo){
        super();
        this.data = data;
        this.valor = valor;
        this.numConta = numConta;
        this.tipo = tipo;
    }

    public Operacao() {
		super();
		this.alOperacoes = new ArrayList<Operacao>();
	}
	public ArrayList<Operacao> getListaOperacoes() {
		return alOperacoes;
	}
    public int getNumConta(){
        return numConta;
    }
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    public void setData(){
        this.data = LocalDate.now();
    }
    public LocalDate getdata(){
        return data;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public float getValor(){
        return valor;
    }
    public void setTipo(TipoOperacao tipo){
        this.tipo = tipo;
    }
    public TipoOperacao getTipo(){
        return tipo;
    }

    public void saque(float valor){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.SAQUE;
        Operacao operacao = new Operacao(data, valor, numConta, tipo);
		alOperacoes.add(operacao);
        
    }
    public void deposito(float valor){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.DEPOSITO;
        Operacao operacao = new Operacao(data, valor, numConta, tipo);
        alOperacoes.add(operacao);
    }
}
