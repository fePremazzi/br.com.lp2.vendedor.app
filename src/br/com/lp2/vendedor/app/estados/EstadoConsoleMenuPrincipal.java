/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.vendedor.app.estados;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.atualiza.EnumEstadoConsoleAtualiza;
import br.com.lp2.vendedor.app.estados.cadastro.EnumEstadoConsoleCadastro;
import br.com.lp2.vendedor.app.estados.consultar.EnumEstadoConsoleConsulta;
import br.com.lp2.vendedor.app.estados.deleta.EnumEstadoConsoleDeleta;
import br.com.lp2.vendedor.app.metodos.Metodos;
import br.com.lp2.vendedor.comum.VO.Funcionario;

public class EstadoConsoleMenuPrincipal extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		System.out.println("*** Menu Principal ***");		
		printMenuCRUD(App.currentUser);
		Scanner scan = new Scanner(System.in);
		
		int opcao = scan.nextInt();
		switch (opcao) {
		case 0:
			App.estadoConsole = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();
			break;
		
		case 1:
			App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();
			break;
		
		case 2:
			App.estadoConsole = EnumEstadoConsoleConsulta.MENU_CONSULTA.getEstadoMaquina();
			break;
		
		case 3:
			App.estadoConsole = EnumEstadoConsoleAtualiza.MENU_ATUALIZA.getEstadoMaquina();
			break;
			
		case 4:
			App.estadoConsole = EnumEstadoConsoleDeleta.MENU_DELETA.getEstadoMaquina();
			break;
		}
		return false;
	}
	
	public static void printMenuCRUD(Funcionario func) {
		System.out.println("Você está logado como: " + func.getUsername());
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar");
		System.out.println("3 - Atualizar");
		System.out.println("4 - Deletar");
		System.out.println("0 - Deslogar");
		System.out.println("Opcao: ");
	}

}
