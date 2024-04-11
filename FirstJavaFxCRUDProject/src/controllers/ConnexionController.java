package controllers;

import dao.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Utilisateur;

import java.io.IOException;

public class ConnexionController {

    @FXML
    private TextField clogin; // Champ de saisie pour le login

    @FXML
    private TextField cpassword; // Champ de saisie pour le mot de passe

    @FXML
    private Button btnConnexion; // Bouton de connexion

    private UtilisateurDAO utilisateurDAO; // Instance du DAO pour gérer les utilisateurs

    public ConnexionController() {
        utilisateurDAO = new UtilisateurDAO(); // Initialiser le DAO
    }

    // Méthode appelée lors du clic sur le bouton de connexion
    @FXML
    private void handleConnexionButton(ActionEvent event) {
        // Récupérer les valeurs des champs de saisie
        String login = clogin.getText();
        String password = cpassword.getText();

        // Vérifier les valeurs de login et de mot de passe
        if (login.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Champs vides", "Veuillez remplir tous les champs.");
        } else {
            // Vérifier l'authentification avec la base de données
            Utilisateur utilisateur = utilisateurDAO.getUtilisateurByLogin(login);
            if (utilisateur != null && utilisateur.getPassword().equals(password)) {
                showAlert(Alert.AlertType.INFORMATION, "Connexion réussie", "Bienvenue, " + utilisateur.getLogin() + " !");
                loadProductManagementScene(event); // Charger la scène de gestion des produits
            } else {
                showAlert(Alert.AlertType.ERROR, "Identifiants incorrects", "Identifiants invalides. Veuillez réessayer.");
            }
        }
    }

    // Méthode pour afficher une alerte
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode pour charger la scène de gestion des produits
    private void loadProductManagementScene(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vue/Product.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
