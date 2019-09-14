package br.com.lp2.vendedor.app.estados.deleta;

import java.util.List;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.service.controller.ProdutoController;

public class EstadoDeletaProduto extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		ProdutoController prodController = new ProdutoController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Deletar PRODUTO ***");

		System.out.println("Digite APENAS o Id do Produto que deseja DELETAR:");

		List<Object> listaProds = prodController.consultaTodos();
		for (Object object : listaProds) {
			Produto cl = (Produto) object;
			System.out.println(cl.toString());
			System.out.println("##################################");
		}
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		prodController.deleta(idEscolhido);

		App.estadoConsole = EnumEstadoConsoleDeleta.MENU_DELETA.getEstadoMaquina();
		return false;
	}

}
