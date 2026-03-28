package models;

import java.util.Date;

public class Operation {
    // Attributs
    private int id_compteSource;
    private double montant;
    private Date date;
    private Type_operation type;
    private Compte compteDestinataire; //pour les TRANSFERT seulement
    private String nomMarchand; // Pour les PAIEMENT seulement

    // Contructeurs
    public Operation(){}
    public Operation(int id_compteSource, double montant, Date date, Type_operation type){
        this.id_compteSource = id_compteSource;
        this.montant = montant;
        this.date = date;
        this.type = type;
    }

    // getters
    public int getCompteSource() {
        return id_compteSource;
    }
    public double getMontant() {
        return montant;
    }
    public Date getDate() {
        return date;
    }
    public Type_operation getType() {
        return type;
    }
    public Compte getCompteDestinataire() {
        return compteDestinataire;
    }
    public String getNomMarchand() {
        return nomMarchand;
    }

    // setters
    public void setNum_compte(int id_compteSource) {
        this.id_compteSource = id_compteSource;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setType(Type_operation type) {
        this.type = type;
    }
    public void setCompteDestinataire(Compte compteDestinataire) {
        this.compteDestinataire = compteDestinataire;
    }
    public void setNomMarchand(String nomMarchand) {
        this.nomMarchand = nomMarchand;
    }

    // fonction d'affichage a ajouter...
}
