package ui;

import java.sql.SQLException;
import java.util.Scanner;

import models.*;
import dao.*;
import services.*;



public class Menu {
    private Scanner in = new Scanner(System.in);
    private ClientService clientService = new ClientService();
    public void start(){
        while(true){
            afficherMenu();
            String choix = in.nextLine();
            switch (choix) {
                case "1": ajouterClient(); break;
                case "2": System.out.println("Au revoir"); return;
                default: System.out.println("Choix invalide.");
            }
        }
    }

    private void afficherMenu(){
        System.out.println("\n=== Mobile Money ===");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Quitter");
        System.out.println("Votre choix: ");
    }

    private void ajouterClient(){
        try{
            System.out.println("Nom: ");
            String nom = in.nextLine();
            System.out.println("Prenom: ");
            String prenom = in.nextLine();
            System.out.println("Numero de telephone: ");
            String tel = in.nextLine();
            System.out.println("Adresse: ");
            String adresse = in.nextLine();

            Client newCli = new Client(nom, prenom, tel, adresse);
            clientService.ajouterClient(newCli);
            System.out.println("Client ajoute avec succes!");
        }
        catch(Exception e){
            System.out.println("Erreur: " + e.getMessage());
        }

    }
}
