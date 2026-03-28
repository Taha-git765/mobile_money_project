package models;

public class Client {
    //Atributs
    private int id;
    private String nom;
    private String prenom;
    private String numero_tel;
    private String adresse;

    // Constructeur sans param
    public Client(){}
    // Constructeur avec param (sans id)
    public Client(String nom, String prenom, String numero_tel, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.numero_tel = numero_tel;
        this.adresse = adresse;
    }
    // Constructeur avec param
    public Client(int id, String nom, String prenom, String numero_tel, String adresse){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numero_tel = numero_tel;
        this.adresse = adresse;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getNumero_tel() {
        return numero_tel;
    }
    public String getAdresse() {
        return adresse;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void afficherClient(){
        System.out.println("id: "+ id+ " - Prenom: "+ prenom+ " - Nom: "+ nom+ " - Telephone: "+ numero_tel+ " - Adresse: "+ adresse);
    }
}
