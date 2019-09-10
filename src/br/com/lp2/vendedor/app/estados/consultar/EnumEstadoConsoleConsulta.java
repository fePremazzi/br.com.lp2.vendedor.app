package br.com.lp2.vendedor.app.estados.consultar;

import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;

public enum EnumEstadoConsoleConsulta {
	
	MENU_CONSULTA(new EstadoMenuConsulta()),

	CONSULTA_PRODUTO(new EstadoConsultaProduto()),

	CONSULTA_PEDIDO(new EstadoConsultaPedido()),

	CONSULTA_CLIENTE(new EstadoConsultaCliente()),

	CONSULTA_FUNCIONARIO(new EstadoConsultaFuncionario());

	private final MaquinaEstadoConsole estadoMaquina;

	EnumEstadoConsoleConsulta(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

	public MaquinaEstadoConsole getEstadoMaquina() {
		return estadoMaquina;
	}
}
