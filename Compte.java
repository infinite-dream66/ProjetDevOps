package modele;

public class Compte {
    private int numero;
    private double montant;
    private String typeCompte;
    private String nom;
    private String prenom;

    // Constructeur
    public Compte(int numero, double montant, String typeCompte, String nom, String prenom) {
        this.numero = numero;
        this.montant = montant;
        this.typeCompte = typeCompte;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getters et Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Méthode pour afficher les informations du compte
    @Override
    public String toString() {
        return "Compte [numero=" + numero + ", montant=" + montant + ", typeCompte=" + typeCompte + ", nom=" + nom + ", prenom=" + prenom + "]";
    }
}
 