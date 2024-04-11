package controllers;

import dao.ProductDAO;
import database.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Product;

import java.sql.Connection;
import java.sql.SQLException;

public class ProductController {

    @FXML
    private Label labellibelle;

    @FXML
    private TextField textFieldquantite; // Change from Label to TextField

    @FXML
    private TextField textFieldprixunitaire; // Change from Label to TextField


    @FXML
    private ComboBox<String> ComboBoxCategories;

    @FXML
    private Button btnaddproduct;

    @FXML
    private Button btnupdateproduct;

    @FXML
    private Button btndeleteproduct;

    @FXML
    private TableView<Product> productTableView;

    @FXML
    private TableColumn<Product, Integer> idColumn;

    @FXML
    private TableColumn<Product, String> libelleColumn;

    @FXML
    private TableColumn<Product, Integer> quantiteColumn;

    @FXML
    private TableColumn<Product, Double> prixUnitaireColumn;

    @FXML
    private TableColumn<Product, Integer> idCategorieColumn;

    @FXML
    private TextField textFieldlibelle;  // Ajout de l'annotation @FXML

    private ProductDAO productDAO;
    private ObservableList<Product> productList;

    @FXML
public void initialize() {
    System.out.println("Controller initialized."); // Ajout du log pour vérification

    productList = FXCollections.observableArrayList();

    // Initialize ProductDAO using DatabaseManager to get connection
    try {
        Connection connection = DatabaseManager.getConnection();
        productDAO = new ProductDAO(connection);
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer l'erreur de connexion ici
    }

    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    libelleColumn.setCellValueFactory(new PropertyValueFactory<>("libelle"));
    quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantite"));
    prixUnitaireColumn.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
    idCategorieColumn.setCellValueFactory(new PropertyValueFactory<>("idCategorie"));

    loadCategories();
    loadProducts();
}


    private void loadCategories() {
        // Load categories logic
        // Example:
        ComboBoxCategories.setItems(FXCollections.observableArrayList("Category 1", "Category 2", "Category 3"));
    }

    private void loadProducts() {
        try {
            productList.clear();
            productList.addAll(productDAO.getAllProducts());
            productTableView.setItems(productList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
private void handleaddproductbutton(ActionEvent event) {
    // Récupérer les données du formulaire pour ajouter un nouveau produit
    String libelle = textFieldlibelle.getText();
    String quantiteText = textFieldquantite.getText();
    String prixUnitaireText = textFieldprixunitaire.getText();
    String selectedCategory = ComboBoxCategories.getValue();

    try {
        int quantite = Integer.parseInt(quantiteText);
        double prixUnitaire = Double.parseDouble(prixUnitaireText);

        // Créer un nouveau produit
        Product newProduct = new Product(libelle, quantite, prixUnitaire, selectedCategory);

        // Appeler la méthode de DAO pour ajouter le produit à la base de données
        productDAO.addProduct(newProduct);
        loadProducts(); // Recharger la liste des produits après l'ajout
    } catch (NumberFormatException e) {
        e.printStackTrace();
        // Gérer l'erreur de conversion ici
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer les erreurs liées à l'ajout du produit ici
    }
}


    @FXML
    private void handleupdateproductbutton(ActionEvent event) {
        // Update product logic
        // You can implement the logic to update a product here
    }

    @FXML
    private void handledeleteproductbutton(ActionEvent event) {
        // Delete product logic
        // You can implement the logic to delete a product here
    }

    @FXML
    private void handleCategorySelection(ActionEvent event) {
        // Filter products by category logic
        String selectedCategory = ComboBoxCategories.getValue();
        if (selectedCategory != null) {
            // Implement filtering logic here based on the selected category
        }
    }
}
