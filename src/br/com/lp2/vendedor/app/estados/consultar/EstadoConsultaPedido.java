package br.com.lp2.vendedor.app.estados.consultar;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Pedido;
import br.com.lp2.vendedor.service.controller.PedidoController;

public class EstadoConsultaPedido extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		PedidoController pedidoController = new PedidoController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Consultar PEDIDO ***");

		System.out.println("Digite APENAS o Id do Pedido que deseja CONSULTAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		Pedido p = pedidoController.consulta(idEscolhido);

		if (p != null)
			System.out.println(p.toString());
		else
			System.out.println("Nao existe produto");

		App.estadoConsole = EnumEstadoConsoleConsulta.MENU_CONSULTA.getEstadoMaquina();

		return false;
	}

}
