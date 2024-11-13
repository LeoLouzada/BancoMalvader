import view.LoginView;
import controller.LoginController;

public class BancoMalvader {

    public static void main(String[] args) {
        // Inicializando a aplicação
        BancoMalvader bancoMalvader = new BancoMalvader();
        bancoMalvader.iniciarAplicacao();
    }

    public void iniciarAplicacao() {
        // Criação da tela de login e controlador
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);

        // Exibindo a tela de login
        loginView.setVisible(true);

        // A lógica de login será controlada pelo LoginController
    }
}
