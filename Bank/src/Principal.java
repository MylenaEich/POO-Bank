import Banco.*;
import Interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.CredentialException;

import java.util.Collections;
import java.util.Iterator;


public class Principal {
    
    private static Banco banco = new Banco(); //Lista de Contas: alContas
	private static Operacao op = new Operacao(); //Lista de Operacoes: alOperacoes
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;


        do {
			System.out.println("\nMENU INICIAL\n");
			System.out.println("0 - sair \n1 - Criar conta Corrente  \n2 - Criar conta Poupanca \n3 - Fazer um deposito");
			System.out.println("4 - Fazer um saque \n5 - Aplicar correcao de juros");
			System.out.println("6 - Cadastrar Pix \n7 - Efetuar Pix");
			System.out.println("8 - Consultar extrato \n");

			opcao = scanner.nextInt();

			switch (opcao) {
				case 0:
					System.out.println("\n   Obrigado por usar o sistema!");
					break;
				case 1:
					criarCC();
					break;
				case 2:
					criarCP();
					break;
				case 3:
					deposito();
					break;
				case 4:
					saque();
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					extrato();
					break;
			}
		} while (opcao != 0);
	}


    private static void criarCC() {

		System.out.println("\n==> Conta Corrente\n");
		scanner.nextLine();

		String nome;
        int numConta;

		System.out.print("   Nome do titular da conta: ");
		nome = scanner.nextLine();
        numConta = scanner.nextInt();
        Corrente corrente = new Corrente(numConta,  nome);
        banco.addConta(corrente);
		System.out.print(" Conta criada!\n Dados: \n Nome: " + nome + "\n numero da conta:" );
	}

	private static void criarCP() {

		System.out.println("\n==> Conta Poupanca\n");
		scanner.nextLine();

		String nome;
        int numConta;

		System.out.print("   Nome do titular da conta: ");
		nome = scanner.nextLine();
        numConta = scanner.nextInt();
        Poupanca poupanca = new Poupanca(numConta,  nome);
        banco.addConta(poupanca);
		System.out.print(" Conta Poupanca criada!\n Dados: \n Nome: " + nome + "\n Numero da conta:\n" );
	}

	private static void deposito(){

		System.out.println("\n==> Deposito\n");

		int numConta;
		float valor;

		System.out.println("Selecione uma conta: \n");
		ListarContas();
		numConta = scanner.nextInt();
		System.out.println("Selecione o valor que deseja depositar: \n");
		valor = scanner.nextFloat();

		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		if(alContas.size() == 0){
			System.out.println("\n Nenhum movimento foi realizado nessa conta! \n");
		}
		for (Conta conta : alContas){
			if(conta.getNumConta() == numConta){
				conta.deposito(valor);
				op.deposito(valor);
				System.out.println("\n Saldo atualizado:" + conta.getsaldo() + "\n");
			}
		}
	}

	private static void saque(){

		System.out.println("\n==> Saque\n");

		int numConta;
		float valor;

		System.out.println("Selecione uma conta: \n");
		ListarContas();
		numConta = scanner.nextInt();
		System.out.println("Selecione o valor que deseja sacar: \n");
		valor = scanner.nextFloat();

		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		if(alContas.size() == 0){
			System.out.println("\n Ainda não há contas cadastradas! \n");
		}
		for (Conta conta : alContas){
			if(conta.getNumConta() == numConta){
				conta.saque(valor);
				op.saque(valor);
				System.out.println("\n Saldo atualizado:" + conta.getsaldo() + "\n");
			}
		}
	}
	private static void ListarContas(){
		System.out.println("\n==> Contas\n");
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		if(alContas.size() == 0){
			System.out.println("\n Ainda não há contas cadastradas! \n");
		}
		for(Conta conta : alContas){
			if(conta instanceof Corrente){
				System.out.println("\n - Conta Corrente - \n");
			}
			else if(conta instanceof Poupanca){
				System.out.println(" \n - Conta Poupanca - \n");
			}
			System.out.println(" Titular " + conta.getNome() + "\n");
			System.out.println(" Numero da conta:  " + conta.getNumConta() + "\n");
			if (conta.getCPF() != null){
				System.out.println("CPF: " + conta.getCPF() + "\n");
			}
			System.out.println(" Saldo " + conta.getsaldo() + "\n");
		}
	}

	private static void extrato(){
		System.out.println("\n==> Extrato\n");
		int numConta;
		System.out.println("Selecione uma conta:\n");
		numConta = scanner.nextInt();

		ArrayList<Operacao> alOperacoes;
		alOperacoes = op.getListaOperacoes();
		
		for(Operacao operacao : alOperacoes){
			if(operacao.getNumConta() == numConta){
				if(alOperacoes.size() == 0){
					System.out.println("\n Nenhum movimento realizado nesta conta \n");
				}
				if(operacao.getTipo() == TipoOperacao.SAQUE){
					System.out.println("Saque       ");
				}
				if(operacao.getTipo() == TipoOperacao.DEPOSITO){
					System.out.println("Deposito       ");
				}
			System.out.println(operacao.getValor() + "        ");
			System.out.println(operacao.getValor() + "        ");
			}
		}
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		for(Conta conta : alContas){
			if(conta.getNumConta() == numConta){
				System.out.println(" Saldo " + conta.getsaldo() + "\n");
			}

		}
	}
}
