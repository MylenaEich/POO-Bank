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
    public void Pix(String CPF1, String CPF2, float valor){
        LocalDate data = LocalDate.now();
        TipoOperacao tipo1 = TipoOperacao.PIXOUT;
        Operacao operacao1 = new Operacao(data, valor, CPF1, tipo1);
        addOperacao(operacao1);
        TipoOperacao tipo2 = TipoOperacao.PIXIN;
        Operacao operacao2 = new Operacao(data, valor, CPF2, tipo2);
        addOperacao(operacao2);
    }

}
