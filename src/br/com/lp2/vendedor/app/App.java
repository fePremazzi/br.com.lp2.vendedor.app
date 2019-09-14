package br.com.lp2.vendedor.app;

import java.io.IOException;
import java.text.ParseException;

import br.com.lp2.vendedor.app.estados.EnumEstadoConsole;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.VO.Funcionario;

public class App {

	public static MaquinaEstadoConsole estadoConsole;
	public static Funcionario currentUser;

	public static void main(String[] args) throws ParseException, InterruptedException, IOException {

		estadoConsole = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();;
        Boolean saida = false;
        while (!saida){
            saida = estadoConsole.Executa();
        }

	}

}
