package br.com.lp2.vendedor.app.estados.deleta;

import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;

public enum EnumEstadoConsoleDeleta {
	
	MENU_DELETA(new EstadoMenuAtualiza()),

	DELETA_PRODUTO(new EstadoDeletaProduto()),

	DELETA_PEDIDO(new EstadoDeletaPedido()),

	DELETA_CLIENTE(new EstadoDeletaCliente()),

	DELETA_FUNCIONARIO(new EstadoDeletaFuncionario());

	private final MaquinaEstadoConsole estadoMaquina;

	EnumEstadoConsoleDeleta(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

	public MaquinaEstadoConsole getEstadoMaquina() {
		return estadoMaquina;
	}

}
