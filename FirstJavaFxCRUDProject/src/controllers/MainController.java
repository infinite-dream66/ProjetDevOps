package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button inscriptionButton; // Référence au bouton d'inscription de la page principale

    @FXML
    private Button connexionButton; // Référence au bouton de connexion de la page principale

    // Méthode appelée lors du clic sur le bouton d'inscription
    @FXML
    private void handleInscriptionButton(ActionEvent event) {
        try {
            // Charger la vue d'inscription à partir du fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Inscription.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène avec la vue chargée
            Scene scene = new Scene(root);

            // Récupérer la scène actuelle à partir de l'événement
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Afficher la nouvelle scène
            currentStage.setScene(scene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur lors du chargement de la page d'inscription.");
        }
    }

    // Méthode appelée lors du clic sur le bouton de connexion
    @FXML
    private void handleConnexionButton(ActionEvent event) {
        try {
            // Charger la vue de connexion à partir du fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/Connexion.fxml"));
            Parent root = loader.load();

            // Créer une nouvelle scène avec la vue chargée
            Scene scene = new Scene(root);

            // Récupérer la scène actuelle à partir de l'événement
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Afficher la nouvelle scène
            currentStage.setScene(scene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Erreur lors du chargement de la page de connexion.");
        }
    }

    // Méthode pour afficher une alerte
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
