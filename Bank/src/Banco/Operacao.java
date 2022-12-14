package Banco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Operacao {
    
    
    private LocalDate data;
    private float valor;
    private int numConta;
    private String CPF;
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
    public Operacao(LocalDate data, float valor, String CPF, TipoOperacao tipo){
        super();
        this.data = data;
        this.valor = valor;
        this.CPF = CPF;
        this.tipo = tipo;
    }
    public Operacao(LocalDate data, float valor,int numConta, String CPF, TipoOperacao tipo){
        super();
        this.data = data;
        this.valor = valor;
        this.numConta = numConta;
        this.CPF = CPF;
        this.tipo = tipo;
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
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public String getCPF(){
        return CPF;
    }
    public void setTipo(TipoOperacao tipo){
        this.tipo = tipo;
    }
    public TipoOperacao getTipo(){
        return tipo;
    }

   
}
