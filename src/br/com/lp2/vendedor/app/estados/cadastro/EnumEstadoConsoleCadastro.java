package br.com.lp2.vendedor.app.estados.cadastro;

import br.com.lp2.vendedor.app.estados.EstadoConsoleMenuPrincipal;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;

public enum EnumEstadoConsoleCadastro {
	
	MENU_CADASTRO(new EstadoMenuCadastro()),

	CADASTRA_PRODUTO(new EstadoCadastraProduto()),

	CADASTRA_PEDIDO(new EstadoCadastraPedido()),

	CADASTRA_CLIENTE(new EstadoCadastraCliente()),

	CADASTRA_FUNCIONARIO(new EstadoCadastraFuncionario());

	private final MaquinaEstadoConsole estadoMaquina;

	EnumEstadoConsoleCadastro(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }

	public MaquinaEstadoConsole getEstadoMaquina() {
		return estadoMaquina;
	}

}
