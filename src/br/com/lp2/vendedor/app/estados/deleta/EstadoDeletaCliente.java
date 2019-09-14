package br.com.lp2.vendedor.app.estados.deleta;

import java.util.List;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.service.controller.ClienteController;

public class EstadoDeletaCliente extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		
		ClienteController clienteController = new ClienteController();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Deletar CLIENTE ***");
		
		System.out.println("Digite APENAS o Id do Cliente que deseja DELETAR:");

		List<Object> listaClientes = clienteController.consultaTodos();
		for (Object object : listaClientes) {
			Cliente cl = (Cliente) object;
			System.out.println(cl.toString());
			System.out.println("##################################");
		}
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();
		
		clienteController.deleta(idEscolhido);		
		
		
		App.estadoConsole = EnumEstadoConsoleDeleta.MENU_DELETA.getEstadoMaquina();
		return false;
	}

}
