package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Utilisateur;
import dao.UtilisateurDAO;

public class InscriptionController {
    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    private UtilisateurDAO utilisateurDAO; // Instance du DAO pour gérer les utilisateurs

    public InscriptionController() {
        utilisateurDAO = new UtilisateurDAO(); // Initialiser le DAO
    }

    @FXML
    private void handleInscription() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();

        // Vérifier si tous les champs sont remplis
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || login.isEmpty() || password.isEmpty()) {
            showAlert("Veuillez remplir tous les champs.");
            return;
        }

        // Créer un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur(0, nom, prenom, email, login, password);

        // Enregistrer l'utilisateur dans la base de données
        boolean inscriptionReussie = utilisateurDAO.inscrireUtilisateur(utilisateur);

        if (inscriptionReussie) {
            showAlert("Inscription réussie !");
            // Effacer les champs après l'inscription
            effacerChamps();
        } else {
            showAlert("Erreur lors de l'inscription. Veuillez réessayer.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void effacerChamps() {
        nomField.clear();
        prenomField.clear();
        emailField.clear();
        loginField.clear();
        passwordField.clear();
    }
}
