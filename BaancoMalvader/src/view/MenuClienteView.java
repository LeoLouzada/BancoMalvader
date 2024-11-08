package view;

import javax.swing.*;

public class MenuClienteView extends JFrame{

    private JButton btnSaldo, btnDeposito, btnSaque, btnExtrato, btnConsultarLimite, btnSair;

    public MenuClienteView() {
        setTitle("Menu Cliente");
        setSize(400, 300);
        setLayout(null);

        btnSaldo = new JButton("Saldo");
        btnDeposito = new JButton("Depósito");
        btnSaque = new JButton("Saque");
        btnExtrato = new JButton("Extrato");
        btnConsultarLimite = new JButton("Consultar Limite");
        btnSair = new JButton("Sair");

        btnSaldo.setBounds(50, 30, 300, 25);
        btnDeposito.setBounds(50, 60, 300, 25);
        btnSaque.setBounds(50, 90, 300, 25);
        btnExtrato.setBounds(50, 120, 300, 25);
        btnConsultarLimite.setBounds(50, 150, 300, 25);
        btnSair.setBounds(50, 180, 300, 25);

        add(btnSaldo);
        add(btnDeposito);
        add(btnSaque);
        add(btnExtrato);
        add(btnConsultarLimite);
        add(btnSair);

        btnSair.addActionListener(e -> dispose());
        // Exemplo de ação para botão
        btnSaldo.addActionListener(e -> BancoController.consultarSaldo());
    }
}
