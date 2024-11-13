package view;

import javax.swing.*;
import controller.MenuController;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    private JButton btnFuncionario, btnCliente, btnSair;
    private MenuController menuController;

    public MenuPrincipalView() {
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        btnFuncionario = new JButton("Funcionário");
        btnCliente = new JButton("Cliente");
        btnSair = new JButton("Sair");

        menuController = new MenuController(this);

        add(btnFuncionario);
        add(btnCliente);
        add(btnSair);

        btnFuncionario.addActionListener(e -> menuController.acessarMenu("funcionario"));
        btnCliente.addActionListener(e -> menuController.acessarMenu("cliente"));
        btnSair.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
    }
}
