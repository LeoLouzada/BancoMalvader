package model;

import controller.BancoController;

import java.time.LocalDate;

public class Funcionario extends Usuario{

    private String codigoFuncionario;
    private String cargo;
    private String senha;

    private BancoController bancoController;

    public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco,
                       String codigoFuncionario, String cargo, String senha, BancoController bancoController) {
        super(id, nome, cpf, dataNascimento, telefone, endereco);
        this.codigoFuncionario = codigoFuncionario;
        this.cargo = cargo;
        this.senha = senha;
        this.bancoController = bancoController;
    }

    @Override
    public boolean login(String senha) {
        return this.senha.equals(senha);
    }

    public void abrirConta(Conta novaConta){
        bancoController.getContas().add(novaConta);
        System.out.println("Conta aberta com sucesso para o cliente: " + novaConta.getCliente().getNome());
    }

    public void encerrarConta(int numeroConta, String senhaAdmin) {
        if (this.senha.equals(senhaAdmin)) {
            Conta contaParaEncerrar = bancoController.getContas().stream()
                    .filter(conta -> conta.getNumero() == numeroConta)
                    .findFirst()
                    .orElse(null);

            if (contaParaEncerrar != null) {
                bancoController.getContas().remove(contaParaEncerrar);
                System.out.println("Conta número " + numeroConta + " encerrada com sucesso.");
            } else {
                System.out.println("Conta não encontrada.");
            }
        } else {
            System.out.println("Senha de administrador incorreta. Encerramento de conta não autorizado.");
        }
    }

    public Conta consultarDadosConta(int numeroConta) {
        return bancoController.getContas().stream()
                .filter(conta -> conta.getNumero() == numeroConta)
                .findFirst()
                .orElse(null); // Retorna null se não encontrar a conta
    }

    public Cliente consultarDadosCliente(int idCliente) {
        return bancoController.getClientes().stream()
                .filter(cliente -> cliente.getId() == idCliente)
                .findFirst()
                .orElse(null); // Retorna null se não encontrar o cliente
    }

    public void alterarDadosConta(Conta conta) {
        Conta contaExistente = bancoController.getContas().stream()
                .filter(c -> c.getNumero() == conta.getNumero())
                .findFirst()
                .orElse(null);

        if (contaExistente != null) {
            contaExistente.setSaldo(conta.getSaldo());
            if (conta instanceof ContaCorrente) {
                ((ContaCorrente) contaExistente).setLimite(((ContaCorrente) conta).getLimite());
                ((ContaCorrente) contaExistente).setDataVencimento(((ContaCorrente) conta).getDataVencimento());
            }
            System.out.println("Dados da conta alterados com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void alterarDadosCliente(Cliente cliente) {
        Cliente clienteExistente = bancoController.getClientes().stream()
                .filter(c -> c.getId() == cliente.getId())
                .findFirst()
                .orElse(null);

        if (clienteExistente != null) {
            clienteExistente.setTelefone(cliente.getTelefone());
            clienteExistente.setEndereco(cliente.getEndereco());
            System.out.println("Dados do cliente alterados com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void cadastrarFuncionario(Funcionario novoFuncionario, String senhaAdmin) {
        if (this.senha.equals(senhaAdmin)) {
            bancoController.getFuncionarios().add(novoFuncionario);
            System.out.println("Funcionário cadastrado com sucesso: " + novoFuncionario.getNome());
        } else {
            System.out.println("Senha de administrador incorreta. Cadastro de funcionário não autorizado.");
        }
    }

    public void gerarRelatorioMovimentacao() {
        // Simulação de geração de relatório
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Movimentação Financeira\n");
        relatorio.append("====================================\n");

        for (Conta conta : bancoController.getContas()) {
            relatorio.append("Conta Número: ").append(conta.getNumero()).append("\n");
            relatorio.append("Cliente: ").append(conta.getCliente().getNome()).append("\n");
            relatorio.append("Saldo: R$ ").append(conta.consultarSaldo()).append("\n");
            relatorio.append("------------------------------------\n");
        }

        // Exibe o relatório no console
        System.out.println(relatorio.toString());
        // Futuramente, o relatório pode ser exportado para Excel utilizando bibliotecas como Apache POI.
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
