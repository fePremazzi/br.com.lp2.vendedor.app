package br.com.lp2.vendedor.app.estados.atualiza;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;

public class EstadoAtualizaPedido extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		System.out.println("NAO IMPLEMENTADO");
		App.estadoConsole = EnumEstadoConsoleAtualiza.MENU_ATUALIZA.getEstadoMaquina();
		return false;
	}

}
