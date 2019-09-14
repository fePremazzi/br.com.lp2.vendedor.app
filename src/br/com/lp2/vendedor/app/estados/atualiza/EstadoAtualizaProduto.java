package br.com.lp2.vendedor.app.estados.atualiza;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.app.estados.cadastro.EnumEstadoConsoleCadastro;
import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.Enums.TipoProduto;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.service.controller.ProdutoController;

public class EstadoAtualizaProduto extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		ProdutoController prodController = new ProdutoController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Atualizacao de PRODUTO ***");

		System.out.println("Digite APENAS o Id do Produto que deseja ATUALIZAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		Produto p = prodController.consulta(idEscolhido);

		if (p != null) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Nome: ");
			String nome = scan2.nextLine();

			System.out.println("Descricao: ");
			Scanner scan3 = new Scanner(System.in);
			scan.nextLine();
			String descricao = scan.nextLine();
			

			double valorUnit = 0;
			boolean repeteValor = false;
			do {
				repeteValor = false;
				try {
					Scanner scan4 = new Scanner(System.in);
					System.out.println("Valor unitario: ");
					valorUnit = scan4.nextFloat();
					repeteValor = false;
				} catch (Exception e) {
					System.out.println("Experimente trocar de . para , ou de , para .");
					repeteValor = true;
				}

			} while (repeteValor);

			TipoProduto tipo = TipoProduto.JOGO_CONSOLE;

			boolean repete = false;
			do {
				System.out.println("Qual o tipo de produto?\n" + "1 - Jogo de console\n" + "2 - Jogo de tabuleiro\n"
						+ "3 - Console");
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

			prodController.atualiza(new Produto(nome, descricao, valorUnit, tipo), idEscolhido);

			System.out.println("Atualizado com sucesso.");
			App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

		} else {
			System.out.println("Nao existe produto");
		}

		return false;
	}

}
