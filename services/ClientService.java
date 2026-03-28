package services;

import java.util.Scanner;

import models.Client;
import dao.ClientDAO;

public class ClientService {
    private ClientDAO Cdao = new ClientDAO();

    public void ajouterClient() /*throws SQLException*/{
        // A ajouter: verifier si le telephone existe deja dans la base
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du client:");
        String nom = sc.next();
        System.out.println("Entrer le prenom du client:");
        String prenom = sc.nextLine();
        System.out.println("Entrer le numero de telephone du client:");
        String num_tel = sc.next();
        System.out.println("Entrer l'adresse du client:");
        String adresse = sc.nextLine();

        Client newCli = new Client(nom, prenom, num_tel, adresse);

        Cdao.ajouterCli_toBD(newCli);
        sc.close();

    }
}
