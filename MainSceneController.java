package vue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.DatabaseManager;

public class MainSceneController implements Initializable {
    @FXML
    private TextField cnumeroCompte;

    @FXML
    private TextField cmontant;

    @FXML
    private TextField ctypeCompte;

    @FXML
    private TextField cnom; // Nouveau champ de texte pour le nom

    @FXML
    private TextField cprenom; // Nouveau champ de texte pour le prénom

    @FXML
    private Button buttonAjouter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Code d'initialisation
    }

    @FXML
    private void ajouterCompte() {
        String numeroCompteText = cnumeroCompte.getText();
        String montantText = cmontant.getText();
        String nom = cnom.getText(); // Récupérer le nom saisi
        String prenom = cprenom.getText(); // Récupérer le prénom saisi

        if (numeroCompteText.isEmpty() || montantText.isEmpty()) {
            showAlert("Veuillez saisir un numéro de compte et un montant.");
            return;
        }

        try {
            int numeroCompte = Integer.parseInt(numeroCompteText);
            double montant = Double.parseDouble(montantText);
            String typeCompte = ctypeCompte.getText();

            // Appeler la méthode insererCompte avec le nom et le prénom en plus
            DatabaseManager.insererCompte(numeroCompte, montant, typeCompte, nom, prenom);

            showAlert("Compte ajouté avec succès !");
        } catch (NumberFormatException e) {
            showAlert("Veuillez saisir des valeurs valides pour le numéro de compte et le montant.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
