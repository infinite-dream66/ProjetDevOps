package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductDAO {
    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product(
    resultSet.getString("Libelle"),
    resultSet.getInt("Quantite"),
    resultSet.getDouble("prix_unitaire"),
    resultSet.getString("idcategorie")
);

                products.add(product);
            }
        }
        return products;
    }

    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (Libelle, Quantite, prix_unitaire, idcategorie) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getLibelle());
            statement.setInt(2, product.getQuantite());
            statement.setDouble(3, product.getPrixUnitaire());
            statement.setString(4, product.getIdCategorie()); // Utiliser setString pour idCategorie
            statement.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        String query = "UPDATE Product SET Libelle=?, Quantite=?, prix_unitaire=?, idcategorie=? WHERE Id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getLibelle());
            statement.setInt(2, product.getQuantite());
            statement.setDouble(3, product.getPrixUnitaire());
            statement.setString(4, product.getIdCategorie()); // Utiliser setString pour idCategorie
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        }
    }

    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Product WHERE Id=?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }

    // Ajoutez d'autres méthodes selon vos besoins, par exemple pour obtenir un produit par son ID, etc.
}
