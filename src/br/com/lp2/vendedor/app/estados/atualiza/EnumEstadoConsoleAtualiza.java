package br.com.lp2.vendedor.app.estados.atualiza;

import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;

public enum EnumEstadoConsoleAtualiza {
	
	MENU_ATUALIZA(new EstadoMenuAtualiza()),

	ATUALIZA_PRODUTO(new EstadoAtualizaProduto()),

	ATUALIZA_PEDIDO(new EstadoAtualizaPedido()),

	ATUALIZA_CLIENTE(new EstadoAtualizaCliente()),

	ATUALIZA_FUNCIONARIO(new EstadoAtualizaFuncionario());

	private final MaquinaEstadoConsole estadoMaquina;

	EnumEstadoConsoleAtualiza(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

	public MaquinaEstadoConsole getEstadoMaquina() {
		return estadoMaquina;
	}

}
