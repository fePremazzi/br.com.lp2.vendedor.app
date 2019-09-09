package br.com.lp2.vendedor.app;

import java.text.ParseException;

import br.com.lp2.vendedor.app.estados.EnumEstadoConsole;
import br.com.lp2.vendedor.app.estados.MaquinaEstadoConsole;
import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.FuncionarioController;

public class App {
	public static MaquinaEstadoConsole estadoConsole;
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		
		estadoConsole = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();;
        Boolean saida = false;
        while (!saida){
            saida = estadoConsole.Executa();
        }
		
		
//		Scanner readLine = new Scanner(System.in); // Create a Scanner object
//		int option = 0;
//		
//		TipoCargo userCargo = Metodos.printLogin();
//		
//		do {
//			Metodos.printMenu(userCargo);			
//			try {
//				option = Integer.parseInt(readLine.nextLine());				
//			} catch (Exception e) {
//				System.out.println("Digite apenas numeros validos");
//			}
//		} while (option < 1 || option > 4);

//		try (FileWriter writer = new FileWriter("app.log"); BufferedWriter bw = new BufferedWriter(writer);) {
//			bw.write("teste");
//
//		} catch (IOException e) {
//			System.err.format("IOException: %s%n", e);
//		}
//
//		Charset charset = Charset.forName("US-ASCII");
//		Path file = Paths.get("app.log");
//		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
//			String line = null;
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (IOException x) {
//			System.err.format("IOException: %s%n", x);
//		}
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter("f.txt", true));) {
//
//			writer.write("1");
//			writer.newLine();
//
//			System.out.println("existe");
//
//		} catch (Exception e) {
//			c
//		}
		
//		Funcionario f = new Funcionario("admin", 1, TipoCargo.GERENTE, "admin", "admin");
//		FuncionarioController fCont = new FuncionarioController();
//		try {
//			boolean b = fCont.insereFuncionario(f);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Foi");
//		

		
		


	}

	
}
