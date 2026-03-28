package models;

public class Compte {
    //Attributs
    private int id;
    private String num_compte;
    private double solde;
    private Client client;

    // Constructeurs
    public Compte(){}

    public Compte(int id, String num_compte, double solde, Client client){
        this.id = id;
        this.num_compte= num_compte;
        this.solde = solde;
        this.client = client;
    }

    // getters
    public int getId() {
        return id;
    }
    public String getNum_compte() {
        return num_compte;
    }
    public double getSolde() {
        return solde;
    }
    public Client getClient() {
        return client;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public void afficherCompte(){
        System.out.println("id: "+ id+ " - numero du compte: "+ num_compte+ " - solde: "+ solde+" - proprietaire: "+ client.getNom()+" "+ client.getPrenom());
    }
}
