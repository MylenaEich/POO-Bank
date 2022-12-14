package Banco;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaOperacao {
    
    private ArrayList<Operacao> alOperacoes;

    public ListaOperacao() {
		super();
		this.alOperacoes = new ArrayList<Operacao>();
	}
	public ArrayList<Operacao> getListaOperacoes() {
		return alOperacoes;
	}
    public void addOperacao(Operacao operacao){
        alOperacoes.add(operacao);
    }
    public void saque(int numConta, float valor){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.SAQUE;
        Operacao operacao = new Operacao(data, valor, numConta, tipo);
		addOperacao(operacao);
        
    }
    public void deposito(int numConta, float valor){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.DEPOSITO;
        Operacao operacao = new Operacao(data, valor, numConta, tipo);
        addOperacao(operacao);
    }
    public void fazPix(String CPF, float valor, int numConta){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.PIXOUT;
        Operacao operacao = new Operacao(data, valor, numConta, CPF, tipo);
        addOperacao(operacao);
        
    }
    public void recebePix(String CPF, float valor, int numConta){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.PIXIN;
        Operacao operacao = new Operacao(data, valor, numConta, CPF, tipo);
        addOperacao(operacao);
    }
    public void correcao(int numConta){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo = TipoOperacao.CORRECAO;
        float valor = (float) 1.1; 
        Operacao operacao = new Operacao(data, valor, numConta, tipo);
        addOperacao(operacao);
    }

}
