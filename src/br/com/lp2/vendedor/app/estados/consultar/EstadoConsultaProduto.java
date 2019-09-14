package br.com.lp2.vendedor.app.estados.consultar;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.service.controller.ProdutoController;

public class EstadoConsultaProduto extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		ProdutoController prodController = new ProdutoController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Consultar PRODUTO ***");

		System.out.println("Digite APENAS o Id do Produto que deseja CONSULTAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();
		
		Produto p = prodController.consulta(idEscolhido);
		
		if(p != null)
			System.out.println(p.toString());
		else
			System.out.println("Nao existe produto");

		App.estadoConsole = EnumEstadoConsoleConsulta.MENU_CONSULTA.getEstadoMaquina();

		return false;
	}

}
