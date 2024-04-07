package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/javafxproject";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void insererCompte(int numeroCompte, double montant, String typeCompte, String nom, String prenom) {
        String sql = "INSERT INTO compte (numerocompte, montant, typecompte, nom, prenom) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection()) {
            System.out.println("Connexion à la base de données établie.");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, numeroCompte);
            stmt.setDouble(2, montant);
            stmt.setString(3, typeCompte);
            stmt.setString(4, nom);
            stmt.setString(5, prenom);

            stmt.executeUpdate();
            System.out.println("Compte ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Autres méthodes de la classe DatabaseManager...
}
