import Banco.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    private static Banco banco = new Banco(); //Lista de Contas: alContas
	//private static Operacao op = new Operacao(); //Lista de Operacoes: alOperacoes
	private static ListaOperacao operacoes = new ListaOperacao();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

		Corrente cc = new Corrente(1, 40, "Mylena","123");
		Corrente cc1 = new Corrente(2, "pan", "321");
		Poupanca cp1 = new Poupanca(3, 100, "Josefina");

		banco.addConta(cc);
		banco.addConta(cc1);
		banco.addConta(cp1);

        do {
			System.out.println("\n\nMENU INICIAL\n");
			System.out.println("0 - sair \n1 - Criar conta Corrente  \n2 - Criar conta Poupanca \n3 - Fazer um deposito");
			System.out.println("4 - Fazer um saque \n5 - Aplicar correcao de juros");
			System.out.println("6 - Cadastrar Pix \n7 - Efetuar Pix");
			System.out.println("8 - Consultar extrato \n9 - Listar Contas \n10 - Listar contas com Pix \n");

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
					correcao();
					break;
				case 6:
					addPix();
					break;
				case 7:
					fazerPix();
					break;
				case 8:
					extrato();
					break;
				case 9:
					ListarContas();
					break;
				case 10:
					contasPix();
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

		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		numConta = alContas.size() + 1;

        Corrente corrente = new Corrente(numConta,  nome);
        banco.addConta(corrente);
		System.out.print(" Conta criada!\n Dados: \n Nome: " + nome + "\n numero da conta:" + numConta);
	}

	private static void criarCP() {

		System.out.println("\n==> Conta Poupanca\n");
		scanner.nextLine();

		String nome;
        int numConta;

		System.out.print("Nome do titular da conta: ");
		nome = scanner.nextLine();

		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		numConta = alContas.size() + 1;

        Poupanca poupanca = new Poupanca(numConta,  nome);
        banco.addConta(poupanca);
		System.out.print(" Conta Poupanca criada!\n Nome: " + nome + "\n Numero da conta:" + numConta);
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
				operacoes.deposito(numConta, valor);
				System.out.println("\n Saldo atualizado: " + conta.getsaldo() + "\n");
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
			System.out.println("\n Ainda n??o h?? contas cadastradas! \n");
		}
		for (Conta conta : alContas){
			if(conta.getNumConta() == numConta){
				while(conta.testaSaldo(valor)){
					System.out.println(" Voc?? n??o tem saldo suficiente! Digite um novo valor:");
					valor = scanner.nextFloat();
				}
				conta.saque(valor);
				System.out.println(conta.testaSaldo(valor));
				operacoes.saque(numConta, valor);
				System.out.println("\n Saldo atualizado:" + conta.getsaldo() + "\n");
			}
		}
	}
	private static void correcao(){
		System.out.println("\n ==> Aplicar Correcao de juros");
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		for (Conta conta : alContas){
			if(conta instanceof Poupanca){
				conta.juros();
				int numConta = conta.getNumConta();
				operacoes.correcao(numConta);
				System.out.println("\n Correcao realizada! ");
			}
		}
	}
	
	private static void ListarContas(){

		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		if(alContas.size() == 0){
			System.out.println("\n Ainda n??o h?? contas cadastradas! \n");
		}
		for(Conta conta : alContas){
			if(conta instanceof Corrente){
				System.out.println("\n Tipo: Conta Corrente");
			}
			else if(conta instanceof Poupanca){
				System.out.println("\n Tipo: Conta Poupanca");
			}
			System.out.println(" Titular " + conta.getNome());
			System.out.println(" Numero da conta:  " + conta.getNumConta());
			if (conta.getCPF() != null){
				System.out.println(" CPF: " + conta.getCPF());
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
		alOperacoes = operacoes.getListaOperacoes();
		
		for(Operacao operacao : alOperacoes){
			if(operacao.getNumConta() == numConta){
				if(alOperacoes.size() == 0){
					System.out.println("\n Nenhum movimento realizado nesta conta \n");
				}
				System.out.println("Data: " + operacao.getdata());
				if(operacao.getTipo() == TipoOperacao.SAQUE){
					System.out.println("\n Saque       ");
				}
				if(operacao.getTipo() == TipoOperacao.DEPOSITO){
					System.out.println("\n Deposito       ");
				}
				if(operacao.getTipo() == TipoOperacao.PIXIN){
					System.out.println(	" Pix Recebido");
				}
				if(operacao.getTipo() == TipoOperacao.PIXOUT){
					System.out.println(" Pix Efetuado");
				}
				if(operacao.getTipo() == TipoOperacao.CORRECAO){
					System.out.println(" Correcao monetaria");
				}
			System.out.println(" Valor: " + operacao.getValor());
			
			}
		
			ArrayList<Conta> alContas;
			alContas = banco.getContas();
			for(Conta conta : alContas){
				if(conta.getNumConta() == numConta){
					System.out.println(" Saldo: " + conta.getsaldo() + "\n");
				}
			}
		}
	}
		
	
	private static void addPix(){

		System.out.println("\n==> Criar Pix \n");
		System.out.println("Selecione uma conta: \n");
		ListarContas();
		int numConta = scanner.nextInt();
		System.out.println("Digite seu CPF: \n");
		String CPF = scanner.next();
		ArrayList<Conta> alContas;
		alContas = banco .getContas();
		for(Conta conta : alContas){
			if(conta instanceof Corrente){
				if(conta.getNumConta() == numConta){
					conta.setCPF(CPF);
				}		
			}
		}
		System.out.println("\n Pix Cadastrado! \n");
	}
	private static void fazerPix(){
		System.out.println("\n ==> Fazer Pix \n");
		System.out.println("Digite o seu Pix:\n");
		String CPF1 = scanner.next();
		System.out.println("Selecione a conta que deseja fazer o pix:\n");
		contasPix();
		String CPF2 = scanner.next();
		System.out.println("Qual valor deseja transferir?\n");
		float valor = scanner.nextFloat();
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		for(Conta conta1 : alContas){
			if(conta1 instanceof Corrente){
				if(conta1.getCPF() == CPF1){
					conta1.fazPix(valor);
					int numConta1 = conta1.getNumConta();
					operacoes.fazPix(CPF1, valor, numConta1);
				}
			}
		}
		for(Conta conta2 : alContas){
			if (conta2 instanceof Corrente){
				if(conta2.getCPF() == CPF2){
					conta2.recebePix(valor);
					int numConta2 = conta2.getNumConta();
					operacoes.recebePix(CPF2, valor, numConta2);
				}
			}
		}
		System.out.println("\n Pix realizado!");
	}

	private static void contasPix(){
		System.out.println("\n ==> Contas com Pix \n");
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		for(Conta conta : alContas){
			if(conta instanceof Corrente){
					System.out.println("\n Titular: " + conta.getNome());
					System.out.println(" N??mero da conta: " + conta.getNumConta());
					if(conta.getCPF() != null){
						System.out.println(" Pix: "+ conta.getCPF());
					}
					System.out.println(" Saldo: " + conta.getsaldo() + "\n");
			}
		}
	}
	private static void contasPoupanca(){
		System.out.println("\n ==> Contas Poupanca \n");
		ArrayList<Conta> alContas;
		alContas = banco.getContas();
		for(Conta conta : alContas){
			if(conta instanceof Poupanca){
					System.out.println("\n Titular: " + conta.getNome());
					System.out.println(" N??mero da conta: " + conta.getNumConta());
					System.out.println(" Saldo: " + conta.getsaldo() + "\n");
			}
		}
	}
}