package br.com.lp2.vendedor.app.estados.atualiza;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.EnumEstadoConsole;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Funcionario;

public class EstadoMenuAtualiza extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		System.out.println("*** Menu ATUALIZAR ***");		
		printMenuCadastro(App.currentUser);
		Scanner scan = new Scanner(System.in);
		
		int opcao = scan.nextInt();
		
		switch (opcao) {
		case 0:
			App.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
			break;
			
		case 1:	
			App.estadoConsole = EnumEstadoConsoleAtualiza.ATUALIZA_PRODUTO.getEstadoMaquina();
			break;
			
		case 2:	
			App.estadoConsole = EnumEstadoConsoleAtualiza.ATUALIZA_PEDIDO.getEstadoMaquina();
			break;
			
		case 3:	
			App.estadoConsole = EnumEstadoConsoleAtualiza.ATUALIZA_CLIENTE.getEstadoMaquina();
			break;
			
		case 4:	
			App.estadoConsole = EnumEstadoConsoleAtualiza.ATUALIZA_FUNCIONARIO.getEstadoMaquina();
			break;

		default:
			break;
		}
		
		return false;
	}
	
	public static void printMenuCadastro(Funcionario func) {
		System.out.println("Você está logado como: " + func.getUsername());
		System.out.println("O que deseja ATUALIZAR?");
		System.out.println("1 - Produto");
		System.out.println("2 - Pedido");
		System.out.println("3 - Cliente");
		System.out.println("4 - Funcionario");
		System.out.println("0 - Voltar");
		System.out.println("Opcao: ");
	}

}
