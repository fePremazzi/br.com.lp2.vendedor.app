package br.com.lp2.vendedor.app.estados.consultar;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.FuncionarioController;

public class EstadoConsultaFuncionario extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		FuncionarioController funcController = new FuncionarioController();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Consultar FUNCIONARIO ***");
		
		System.out.println("Digite APENAS o Id do Funcionario que deseja CONSULTAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();
		
		Funcionario f = funcController.consulta(idEscolhido);
		
		if (f != null)
			System.out.println(f.toString());
		else
			System.out.println("Nao existe funcionario");
		
		App.estadoConsole = EnumEstadoConsoleConsulta.MENU_CONSULTA.getEstadoMaquina();
		
		return false;
	}

}
