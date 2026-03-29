package ui;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

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
                case "2": afficherClients(); break;
                case "3": System.out.println("Au revoir"); return;
                default: System.out.println("Choix invalide.");
            }
        }
    }

    private void afficherMenu(){
        System.out.println("\n=== Mobile Money ===");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Lister les clients");
        System.out.println("3. Quitter");
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

    private void afficherClients(){
        try{
            List<Client> clients = clientService.listerClients();
            if (clients.isEmpty()) {
                System.out.println("Aucun client.");
            }
            else{
                System.out.println("Voici la liste des clients:");
                for(Client c : clients){
                    c.afficherClient();
                }
            }
        } catch(SQLException e){
            System.out.println("Erreur BD: " + e.getMessage());
        }
    }
}
