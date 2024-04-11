import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML de la vue principale
        Parent rootMain = FXMLLoader.load(getClass().getResource("/vue/Main.fxml"));
        primaryStage.setTitle("Votre titre ici"); // Titre de la fenêtre
        primaryStage.setScene(new Scene(rootMain, 800, 600)); // Définir la scène avec la vue chargée
        primaryStage.show(); // Afficher la fenêtre principale
    }

    public static void main(String[] args) {
        launch(args); // Lancer l'application JavaFX
    }
}
