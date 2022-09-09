import Banco.*;
import Interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;


public class Principal {
    
    private static Banco banco = new Banco();
	private static Operacao op = new Operacao();
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
					
					break;

				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					
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
}
