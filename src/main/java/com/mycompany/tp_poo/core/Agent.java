
package com.mycompany.tp_poo.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Agent extends Contact{
    private double salaire;
    private String statut;
    private String categorie;
    private String indiceDeSalaire;
    private String occupation;

    public Agent() {
    }

    public Agent(double salaire, String statut, String categorie, String indiceDeSalaire, String occupation, String code, String nom, Date dateDeNaissance, String adresse, String email, String telNumber) {
        super(code, nom, dateDeNaissance, adresse, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceDeSalaire = indiceDeSalaire;
        this.occupation = occupation;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIndiceDeSalaire() {
        return indiceDeSalaire;
    }

    public void setIndiceDeSalaire(String indiceDeSalaire) {
        this.indiceDeSalaire = indiceDeSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    @Override
    public void ajouterALaBD(Connection conn) {
        try {
            
            String query = "insert into agent(code, nom, dateDeNaissance, adress, email, telNumber, "
                    + "salaire, statut, categorie, indiceDeSalaire, occupation) "
                    + "values(?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
            
            java.sql.Date date = new java.sql.Date(this.getDateDeNaissance().getTime());
            
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, this.getCode());
            st.setString(2, this.getNom());
            st.setDate(3, date);
            st.setString(4, this.getAdresse());
            st.setString(5, this.getEmail());
            st.setString(6, this.getTelNumber());
            st.setDouble(7, this.salaire);
            st.setString(8, this.getStatut());
            st.setString(9, this.categorie);
            st.setString(10, this.indiceDeSalaire);
            st.setString(11, this.occupation);
            
            int rs = st.executeUpdate();
            
            if(rs == 1){
                System.out.println("Successfully update");
            }else{
                System.out.println("Error during insert");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
