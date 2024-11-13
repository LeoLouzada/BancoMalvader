package controller;

import view.MenuPrincipalView;
import view.MenuFuncionarioView;
import view.MenuClienteView;

public class MenuController {

    private MenuPrincipalView menuPrincipalView;

    public MenuController(MenuPrincipalView menuPrincipalView) {
        this.menuPrincipalView = menuPrincipalView;
    }

    public void acessarMenu(String tipoUsuario) {
        if ("funcionario".equals(tipoUsuario)) {
            // Exibir menu do funcionário
            MenuFuncionarioView menuFuncionarioView = new MenuFuncionarioView();
            menuFuncionarioView.setVisible(true);
            menuPrincipalView.setVisible(false);  // Fecha a tela atual
        } else if ("cliente".equals(tipoUsuario)) {
            // Exibir menu do cliente
            MenuClienteView menuClienteView = new MenuClienteView();
            menuClienteView.setVisible(true);
            menuPrincipalView.setVisible(false);  // Fecha a tela atual
        }
    }
}
