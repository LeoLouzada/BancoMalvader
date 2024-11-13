package view;

import javax.swing.*;
import java.awt.*;

public class MenuClienteView extends JFrame {
    private JButton btnConsultarDados, btnAlterarDados, btnExtrato;

    public MenuClienteView() {
        setTitle("Menu Cliente");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        btnConsultarDados = new JButton("Consultar Dados");
        btnAlterarDados = new JButton("Alterar Dados");
        btnExtrato = new JButton("Gerar Extrato");

        add(btnConsultarDados);
        add(btnAlterarDados);
        add(btnExtrato);

        setLocationRelativeTo(null);
    }
}
