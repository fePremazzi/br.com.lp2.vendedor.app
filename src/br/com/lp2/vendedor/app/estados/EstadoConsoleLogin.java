/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.vendedor.app.estados;

import java.util.Scanner;

import br.com.lp2.vendedor.app.App;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.service.controller.FuncionarioController;


public class EstadoConsoleLogin extends MaquinaEstadoConsole {

    @Override
    public boolean Executa() {
        boolean sair = false;
        Funcionario user = new Funcionario();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu usuario");
        user.setUsername(scan.nextLine());
        System.out.println("Digite sua senha");
        user.setSenha(scan.nextLine());
        
        FuncionarioController funcController = new FuncionarioController();
        boolean haceAccess = funcController.validByUsername(user);
        
        if (haceAccess)
            App.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        else {
            System.out.println("Dados invalidos!");
        }            
        return sair;
    }
}
