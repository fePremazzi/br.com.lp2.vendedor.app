package br.com.lp2.vendedor.app.estados.atualiza;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.app.estados.cadastro.EnumEstadoConsoleCadastro;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.service.controller.ClienteController;

public class EstadoAtualizaCliente extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		ClienteController clienteController = new ClienteController();

		Scanner scan = new Scanner(System.in);
		System.out.println("*** Atualizacao de CLIENTES ***");

		System.out.println("Digite APENAS o Id do Cliente que deseja ATUALIZAR:");
		System.out.println("Id escolhido: ");
		int idEscolhido = scan.nextInt();

		Cliente c = clienteController.consulta(idEscolhido);
		if (c != null) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Nome: ");
			String nome = scan2.nextLine();
			String data = null;
			boolean repete = false;
			do {
				
				System.out.println("Data de nascimento (dd/MM/yyyy): ");
				data = scan.next();
				if (isThisDateValid(data, "dd/MM/yyyy"))
					repete = false;
				else
					repete = true;

			} while (repete);

			System.out.println("CPF: ");
			String cpf = scan.next();
			System.out.println("Endereco: ");
			Scanner scan3 = new Scanner(System.in);
			String endereco = scan3.nextLine();

			clienteController.atualiza(new Cliente(nome, data, cpf, endereco), idEscolhido);
			System.out.println("Atualizado com sucesso.");
			App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

		} else {
			System.out.println("Nao existe cliente");
		}

		return false;
	}

	private boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

}
