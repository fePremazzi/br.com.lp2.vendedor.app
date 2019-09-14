package br.com.lp2.vendedor.app.estados.deleta;

import java.util.List;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.FuncionarioController;

public class EstadoDeletaFuncionario extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		FuncionarioController funcController = new FuncionarioController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Deletar FUNCIONARIO ***");

		System.out.println("Digite APENAS o Id do Funcionario que deseja DELETAR:");

		List<Object> listaFuncs = funcController.consultaTodos();
		for (Object object : listaFuncs) {
			Funcionario cl = (Funcionario) object;
			System.out.println(cl.toString());
			System.out.println("##################################");
		}
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		funcController.deleta(idEscolhido);

		App.estadoConsole = EnumEstadoConsoleDeleta.MENU_DELETA.getEstadoMaquina();
		return false;
	}

}
