package br.com.lp2.vendedor.app;

import java.text.ParseException;
import java.util.Scanner;

import br.com.lp2.vendedor.comum.Enums.TipoCargo;

public class App {
	public static void main(String[] args) throws ParseException, InterruptedException {
		Scanner readLine = new Scanner(System.in); // Create a Scanner object
		int option = 0;
		
		TipoCargo userCargo = printLogin();
		
		do {
			printMenu(userCargo);			
			try {
				option = Integer.parseInt(readLine.nextLine());				
			} catch (Exception e) {
				System.out.println("Digite apenas numeros validos");
			}
		} while (option < 1 || option > 4);
		
		
	}

	private static TipoCargo printLogin() throws InterruptedException {
		boolean repeat = true;
		int usuario = 0;
		while (repeat) {
			Scanner readLine = new Scanner(System.in); // Create a Scanner object
			System.out.println("Qual tipo de usuario deseja entrar no sistema:");
			System.out.println("1 - Gerente \n2 - Vendedor \nEscolha: ");
			try {
				usuario = Integer.parseInt(readLine.nextLine());
			} catch (Exception e) {
				System.out.println("Digite apenas numeros validos");
			}
			
			if (usuario == 1 || usuario == 2)
				repeat = false;
		}
		int sleepTime = 2000;
		switch (usuario) {
		case 1:
			System.out.println("Logando como Gerente ...\n\n");
			Thread.sleep(sleepTime);
			return TipoCargo.GERENTE;

		case 2:
			System.out.println("Logando como Vendedor ...\n\n");
			Thread.sleep(sleepTime);
			return TipoCargo.VENDEDOR;

		default:
			System.out.println("Logando como Vendedor ...\n\n");
			Thread.sleep(sleepTime);
			return TipoCargo.VENDEDOR;
		}
	}

	private static void printMenu(TipoCargo userCargo) {
		System.out.println("Voce esta logado como " + userCargo);
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Cadastrar pedido");
		System.out.println("3 - Cadastrar funcionario");
		System.out.println("4 - Cadastrar cliente");
		System.out.println("Opcao: ");
	}
}
