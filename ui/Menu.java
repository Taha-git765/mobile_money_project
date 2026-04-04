package ui;

import dao.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import models.*;
import services.*;

public class Menu {

    private static final String RESET = "\u001b[0m";
    private static final String GREEN = "\u001b[32m";
    private static final String CYAN = "\u001b[36m";
    private static final String YELLOW = "\u001b[33m";
    private static final String BOLD = "\u001b[1m";
    private static final String RED = "\u001b[31m";
    private Scanner in = new Scanner(System.in);
    private ClientService clientService = new ClientService();

    public void start() {
        while (true) {
            afficherMenu();
            String choix = in.nextLine();
            switch (choix) {
                case "1":
                    ajouterClient();
                    break;
                case "2":
                    afficherClients();
                    break;
                case "3":
                    System.out.println("Au revoir");
                    return;
                case "4":
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void afficherMenu() {
        System.out.println();
        System.out.println(
            "\u001b[32m╔══════════════════════════════════╗\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[1m\u001b[36m         MOBILE MONEY            \u001b[0m\u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m╠══════════════════════════════════╣\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[1]\u001b[0m  Ajouter un client          \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[2]\u001b[0m  Afficher les clients       \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[3]\u001b[0m  Créer un compte            \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[4]\u001b[0m  Dépôt                      \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[5]\u001b[0m  Retrait                    \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[6]\u001b[0m  Transfert                  \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[7]\u001b[0m  Paiement marchand          \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[33m[8]\u001b[0m  Liste des opérations       \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m╠══════════════════════════════════╣\u001b[0m"
        );
        System.out.println(
            "\u001b[32m║\u001b[0m  \u001b[31m[9]\u001b[0m  Quitter                    \u001b[32m║\u001b[0m"
        );
        System.out.println(
            "\u001b[32m╚══════════════════════════════════╝\u001b[0m"
        );
        System.out.print("\u001b[33m    Votre choix : \u001b[0m");
    }

    private void ajouterClient() {
        try {
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
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private void afficherClients() {
        try {
            List<Client> clients = clientService.listerClients();
            if (clients.isEmpty()) {
                System.out.println("Aucun client.");
            } else {
                System.out.println("Voici la liste des clients:");
                for (Client c : clients) {
                    c.afficherClient();
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur BD: " + e.getMessage());
        }
    }
}
