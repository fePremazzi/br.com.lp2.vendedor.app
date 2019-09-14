package br.com.lp2.vendedor.app.estados.atualiza;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.app.estados.cadastro.EnumEstadoConsoleCadastro;
import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.FuncionarioController;

public class EstadoAtualizaFuncionario extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		FuncionarioController funcController = new FuncionarioController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Atualizacao de FUNCIONARIO ***");

		System.out.println("Digite APENAS o Id do Funcionario que deseja ATUALIZAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		Funcionario f = funcController.consulta(idEscolhido);
		
		if (f != null) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Nome: ");
			String nome = scan2.nextLine();
	
			System.out.println("Username: ");
			Scanner scan3 = new Scanner(System.in);
			String username = scan.next();
			
			System.out.println("Senha: ");
			Scanner scan4 = new Scanner(System.in);
			String senha = scan.next();
			
			TipoCargo tipo = TipoCargo.VENDEDOR;

			boolean repete = false;
			do {
				System.out.println(
						"Qual o tipo de cargo?\n" + "1 - Vendedor\n" + "2 - Gerente");
				int opcaoTipo = scan.nextInt();

				switch (opcaoTipo) {
				case 1:
					tipo = TipoCargo.VENDEDOR;
					repete = false;
					break;

				case 2:
					tipo = TipoCargo.GERENTE;
					repete = false;
					break;		

				default:
					System.out.println("Opcao invalida");
					repete = true;
					break;
				}
			} while (repete);

			try {
				funcController.atualiza(App.currentUser,new Funcionario(nome, tipo, username, senha), idEscolhido);
			} catch (Exception e) {
				System.out.println("NAO FOI POSSIVEL CADASTRAR, TENTE NOVAMENTE");;
			}
			System.out.println("Atualizado com sucesso.");
			App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

		} else {
			System.out.println("Nao existe funcionario");
		}
		
		
		return false;
	}

}
