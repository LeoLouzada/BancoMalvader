package model;

import java.time.LocalDate;
import java.util.List;

public class Cliente extends Usuario{

    private String senha;
    private Conta conta;

    private List<Conta> contas;

    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento, String telefone, Endereco endereco,
                   String senha, Conta conta, List<Conta> contas) {
        super(id, nome, cpf, dataNascimento, telefone, endereco);
        this.senha = senha;
        this.conta = conta;
    }

    @Override
    public boolean login(String senha) {
        return this.senha.equals(senha);
    }

    public double consultarSaldo(Conta conta) {
        return conta.consultarSaldo();
    }

    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public boolean sacar(Conta conta, double valor) {
        return conta.sacar(valor);
    }

    //public void gerarExtrato(int numeroConta) {}

    public double consultarLimite(int numeroConta) {
        Conta conta = buscarContaPorNumero(numeroConta);
        if (conta != null && conta instanceof ContaCorrente) {
            return ((ContaCorrente) conta).getLimite(); // Retorna o limite da ContaCorrente
        } else {
            System.out.println("Conta não encontrada ou não é uma Conta Corrente.");
            return 0; // Retorna 0 se não for uma ContaCorrente ou não for encontrada
        }
    }

    // Método auxiliar para buscar conta pelo número
    private Conta buscarContaPorNumero(int numeroConta) {
        return this.contas.stream()
                .filter(conta -> conta.getNumero() == numeroConta)
                .findFirst()
                .orElse(null); // Retorna null se a conta não for encontrada
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
