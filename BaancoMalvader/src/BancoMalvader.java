import controller.BancoController;
import view.LoginView;

public class BancoMalvader {

    public static void main(String[] args) {
        // Inicializa o controlador principal
        BancoController bancoController = new BancoController();

        // Carrega os dados salvos
        bancoController.carregarDados();

        // Inicia a interface de login
        LoginView loginView = new LoginView(bancoController);
        loginView.setVisible(true);

        // Adiciona um shutdown hook para salvar os dados ao encerrar a aplicação
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            bancoController.salvarDados();
            System.out.println("Dados salvos com sucesso ao encerrar a aplicação.");
        }));
    }
}
