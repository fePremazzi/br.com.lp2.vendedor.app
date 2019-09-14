package br.com.lp2.vendedor.app.estados.deleta;

import java.util.List;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Pedido;
import br.com.lp2.vendedor.service.controller.PedidoController;

public class EstadoDeletaPedido extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		PedidoController pedidoController = new PedidoController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Deletar PEDIDO ***");

		System.out.println("Digite APENAS o Id do Pedido que deseja DELETAR:");

		List<Object> listaPedidos = pedidoController.consultaTodos();
		for (Object object : listaPedidos) {
			Pedido cl = (Pedido) object;
			System.out.println(cl.toString());
			System.out.println("##################################");
		}
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		pedidoController.deleta(idEscolhido);

		App.estadoConsole = EnumEstadoConsoleDeleta.MENU_DELETA.getEstadoMaquina();
		return false;
	}

}
