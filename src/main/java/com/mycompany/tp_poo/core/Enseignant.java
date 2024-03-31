
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
public class Enseignant extends Contact{
    private String statut;

    public Enseignant() {
    }

    public Enseignant(String statut, String code, String nom, Date dateDeNaissance, String adresse, String email, String telNumber) {
        super(code, nom, dateDeNaissance, adresse, email, telNumber);
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    @Override
    public void ajouterALaBD(Connection conn) {
        try {            
            String query = "insert into enseignant(code, nom, dateDeNaissance, adress, email, "
                    + "telNumber, statut) values (?, ?, ?, ?, ? ,?, ?)";
            
            java.sql.Date date = new java.sql.Date(this.getDateDeNaissance().getTime());
            
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, this.getCode());
            st.setString(2, this.getNom());
            st.setDate(3, date);
            st.setString(4, this.getAdresse());
            st.setString(5, this.getEmail());
            st.setString(6, this.getTelNumber());
            st.setString(7, this.getStatut());
            
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
