package br.com.lp2.vendedor.app.estados.consultar;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.service.controller.ClienteController;

public class EstadoConsultaCliente extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		ClienteController clienteController = new ClienteController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Consultar CLIENTE ***");

		System.out.println("Digite APENAS o Id do Cliente que deseja CONSULTAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		Cliente c = clienteController.consulta(idEscolhido);

		if (c != null)
			System.out.println(c.toString());
		else
			System.out.println("Nao existe cliente");

		App.estadoConsole = EnumEstadoConsoleConsulta.MENU_CONSULTA.getEstadoMaquina();

		return false;
	}

}
