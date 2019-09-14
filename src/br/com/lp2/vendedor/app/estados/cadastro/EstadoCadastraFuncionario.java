package br.com.lp2.vendedor.app.estados.cadastro;

import java.util.Date;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.Enums.TipoProduto;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.ClienteController;
import br.com.lp2.vendedor.service.controller.FuncionarioController;

public class EstadoCadastraFuncionario extends MaquinaEstadoConsole {

	@Override
	public boolean Executa()  {
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Cadastro de FUNCIONARIOS ***");
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		System.out.println("Username: ");
		String username = scan.nextLine();
		System.out.println("Senha: ");
		String senha = scan.nextLine();

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

		FuncionarioController funcController = new FuncionarioController();
		
		try {
			funcController.insere(new Funcionario(nome, tipo, username, senha));
		} catch (Exception e) {
			System.out.println("NAO FOI POSSIVEL CADASTRAR, TENTE NOVAMENTE");;
		}
		
		App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();
		return false;
	}

}
