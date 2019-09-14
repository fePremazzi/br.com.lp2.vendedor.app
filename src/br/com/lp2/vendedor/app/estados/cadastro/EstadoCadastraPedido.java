package br.com.lp2.vendedor.app.estados.cadastro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.comum.VO.Pedido;
import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.service.controller.ClienteController;
import br.com.lp2.vendedor.service.controller.PedidoController;
import br.com.lp2.vendedor.service.controller.ProdutoController;

public class EstadoCadastraPedido extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		/*
		 * 
		 * private List<Produto> listaProdutos; private Cliente cliente; private
		 * Funcionario funcionario;
		 * 
		 */
		ClienteController clienteController = new ClienteController();
		ProdutoController prodController = new ProdutoController();
		PedidoController pedidoController = new PedidoController();

		Pedido pedido = new Pedido();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Cadastro de PEDIDOS ***");
		System.out.println("Nome: ");
		pedido.setNome(scan.nextLine());

		// Deve mostrar todos os clientes e permitir que o usuario escolhe qual cliente
		// deseja selecionar
		System.out.println("Digite APENAS o Id do Cliente que deseja selecionar para fazer o pedido:");

		List<Object> listaClientes = clienteController.consultaTodos();
		for (Object object : listaClientes) {
			Cliente cl = (Cliente) object;
			System.out.println(cl.toString());
			System.out.println("##################################");
		}
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		pedido.setCliente(clienteController.consulta(idEscolhido));
		pedido.setUsuario(App.currentUser);

		boolean adiciona = false;
		List<Object> listaProdutos = prodController.consultaTodos();
		pedido.setListaProdutos(new ArrayList<Produto>());
		do {
			System.out.println("Selecione um produto pelo seu Id:");
			
			for (Object object : listaProdutos) {
				Produto prod = (Produto) object;
				System.out.println(prod.toString());
				System.out.println("##################################");
			}

			System.out.println("Id escolhido: ");
			int prodEscolhido = scan.nextInt();
			Produto p = prodController.consulta(prodEscolhido);
			pedido.getListaProdutos().add(p);

			System.out.println("Deseja adicionar mais algum produto? (S/N)");
			String escolha = scan.next();
			if ( escolha.toUpperCase().equals("S")) {
				adiciona = true;
			} else {
				adiciona = false;
			}

		} while (adiciona);
		System.out.println(pedido.getListaProdutos().size());
		pedidoController.insere(pedido);
		System.out.println("Cadastrado com sucesso.");
		App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

		return false;
	}

}
