package services;

import java.util.Scanner;

import models.Client;
import dao.ClientDAO;

public class ClientService {
    private ClientDAO clientDAO = new ClientDAO();

    public void ajouterClient(Client newCli) /*throws SQLException*/{
        // A ajouter: verifier si le telephone existe deja dans la base
        clientDAO.ajouterCli_toBD(newCli);
    }
}
