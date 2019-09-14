package br.com.lp2.vendedor.app.estados.cadastro;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.Enums.TipoProduto;
import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.service.controller.ProdutoController;

public class EstadoCadastraProduto extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Cadastro de PRODUTOS ***");
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		System.out.println("Descricao: ");
		String descricao = scan.nextLine();
		
		double valorUnit = 0;
		boolean repeteValor = false;
		do {
			repeteValor = false;
			try {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Valor unitario: ");
				valorUnit = scan2.nextFloat();
				repeteValor = false;
			} catch (Exception e) {
				System.out.println("Experimente trocar de . para , ou de , para .");
				repeteValor = true;
			}
			
		} while (repeteValor);
		

		TipoProduto tipo = TipoProduto.JOGO_CONSOLE;
		
		boolean repete = false;
		do {
			System.out.println(
					"Qual o tipo de produto?\n" + "1 - Jogo de console\n" + "2 - Jogo de tabuleiro\n" + "3 - Console");
			int opcaoTipo = scan.nextInt();
			
			switch (opcaoTipo) {
			case 1:
				tipo = TipoProduto.JOGO_CONSOLE;
				repete = false;
				break;

			case 2:
				tipo = TipoProduto.JOGO_TABULEIRO;
				repete = false;
				break;

			case 3:
				tipo = TipoProduto.CONSOLE;
				repete = false;
				break;

			default:
				System.out.println("Opcao invalida");
				repete = true;
				break;
			}
		} while (repete);
		
		ProdutoController prodController = new ProdutoController();
		prodController.insere(new Produto(nome, descricao, valorUnit, tipo));
		System.out.println("Cadastrado com sucesso.");
		App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

		return false;
	}

}
