package model;

public class Funcionario extends Usuario{

    private String codigoFuncionario;
    private String cargo;
    private String senha;

    public void abrirConta(Conta conta){

    }

    public void encerrarConta(Conta conta){

    }

    public Conta consultarDadosConta(int numeroConta){

    }

    public Cliente consultarDadosCliente(int idCliente){

    }

    public void alterarDadosConta(Conta conta){

    }

    public void alterarDadosCliente(Cliente cliente){

    }

    public void cadastrarFuncionario(Funcionario funcionario){

    }

    public void gerarRelatorioMovimentacao(){

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
