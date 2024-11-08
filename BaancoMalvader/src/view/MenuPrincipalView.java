package view;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {

    private JButton btnFuncionario;
    private JButton btnCliente;
    private JButton btnSair;

    public MenuPrincipalView(String tipoUsuario) {
        setTitle("Menu Principal");
        setSize(300, 200);
        setLayout(null);

        btnFuncionario = new JButton("Funcionário");
        btnCliente = new JButton("Cliente");
        btnSair = new JButton("Sair");

        btnFuncionario.setBounds(50, 30, 200, 25);
        btnCliente.setBounds(50, 70, 200, 25);
        btnSair.setBounds(50, 110, 200, 25);

        add(btnFuncionario);
        add(btnCliente);
        add(btnSair);

        btnFuncionario.addActionListener(e -> new MenuFuncionarioView().setVisible(true));
        btnCliente.addActionListener(e -> new MenuClienteView().setVisible(true));
        btnSair.addActionListener(e -> System.exit(0));
    }
}
