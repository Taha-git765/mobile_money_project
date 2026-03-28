package ui;

import java.util.Scanner;

import models.*;
import dao.*;
import services.*;



public class Menu {
    private Scanner in = new Scanner(System.in);
    private ClientService cliService = new ClientService();
    public void afficherMenu(){
        while(true){
            System.out.println("1. Ajouter un client");
            System.out.println("2. Quitter");

            String choix = in.next();

            if(choix.equals("1"))
                cliService.ajouterClient();
            else{
                System.out.println("Bye!!!");
                break;
            }
            in.close();
        }
    }
}
