package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Informations de connexion à la base de données
    private static final String DB_URL = "jdbc:mysql://localhost:3306/projetjavafx_db";
    private static final String DB_USER = "root"; // Mettez votre nom d'utilisateur MySQL
    private static final String DB_PASSWORD = ""; // Mettez votre mot de passe MySQL

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
