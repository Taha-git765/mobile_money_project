package dao;

import models.Client;
import database.db_connection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientDAO {

    // Ajouter un client
    /* 
    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO client (nom, prenom, telephone, adresse) VALUES (?, ?, ?, ?)";
        try (Connection conn = db_connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getPrenom());
            stmt.setString(3, client.getNumero_tel());
            stmt.setString(4, client.getAdresse());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                client.setId(rs.getInt(1));
            }
        }
    }
    */

    public void ajouterCli_toBD(Client client){
        try{
        Connection conn = db_connection.getConnection();
        String requete = "INSERT INTO clients(Nom, Prenom, Numero_tel, Adresse) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(requete);
        //stmt.setInt(0, client.getId());
        stmt.setString(1, client.getNom());
        stmt.setString(2, client.getPrenom());
        stmt.setString(3, client.getNumero_tel());
        stmt.setString(4, client.getAdresse());
        stmt.executeUpdate();
        stmt.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Client> getAllClients() throws SQLException{
        List<Client> clients = new ArrayList<>();
        String requete = "SELECT * FROM clients";
        try(Connection conn = db_connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(requete)){
                while (rs.next()) {
                    Client client = new Client();
                    client.setId(rs.getInt("id"));
                    client.setNom(rs.getString("Nom"));
                    client.setPrenom(rs.getString("Prenom"));
                    client.setNumero_tel(rs.getString("Numero_tel"));
                    client.setAdresse(rs.getString("Adresse"));
                    clients.add(client);
                }
            }
        return clients;
    }
    
}