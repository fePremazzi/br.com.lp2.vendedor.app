/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.vendedor.app.estados;


import java.util.Scanner;

import br.com.lp2.vendedor.app.App;


public class EstadoConsoleMenuPrincipal extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("*** Menu Principal");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Sair");
        int opcao = scan.nextInt();
        switch (opcao)
        {
            case 0:
                App.estadoConsole = EnumEstadoConsole.BEM_VINDO.getEstadoMaquina();
                break;
            case 1:
                
                break;
        }
        return false;
    }
    
}
