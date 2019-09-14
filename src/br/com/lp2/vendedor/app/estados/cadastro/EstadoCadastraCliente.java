package br.com.lp2.vendedor.app.estados.cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.service.controller.ClienteController;

public class EstadoCadastraCliente extends MaquinaEstadoConsole {

	@Override
	public boolean Executa() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*** Cadastro de CLIENTES ***");
		System.out.println("Nome: ");
		String nome = scan.nextLine();
		String data = null;
		boolean repete = false;
		do {

			System.out.println("Data de nascimento (dd/MM/yyyy): ");
			data = scan.nextLine();
			if (isThisDateValid(data, "dd/MM/yyyy"))
				repete = false;
			else
				repete = true;

		} while (repete);

		System.out.println("CPF: ");
		String cpf = scan.nextLine();
		System.out.println("Endereco: ");
		String endereco = scan.nextLine();

		ClienteController clienteController = new ClienteController();
		clienteController.insere(new Cliente(nome, data, cpf, endereco));
		System.out.println("Cadastrado com sucesso.");
		App.estadoConsole = EnumEstadoConsoleCadastro.MENU_CADASTRO.getEstadoMaquina();

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
