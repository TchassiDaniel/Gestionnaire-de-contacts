
package com.mycompany.tp_poo.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Etudiant extends Contact{
    private String cycle;
    private int niveau;

    public Etudiant(String cycle, int niveau, String code, String nom, Date dateDeNaissance, String adresse, String email, String telNumber) {
        super(code, nom, dateDeNaissance, adresse, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
        
    }

    public Etudiant() {
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public void ajouterALaBD(Connection conn) {
        try {
            
            java.sql.Date date = new java.sql.Date(this.getDateDeNaissance().getTime());
            
            String query = "insert into etudiant(code, nom, dateDeNaissance, adress, email, "
                    + "telNumber, cycle, niveau) values (?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st = conn.prepareStatement(query);
            
            st.setString(1, this.getCode());
            st.setString(2, this.getNom());
            st.setDate(3, date);
            st.setString(4, this.getAdresse());
            st.setString(5, this.getEmail());
            st.setString(6, this.getTelNumber());
            st.setString(7, this.getCycle());
            st.setInt(8, this.getNiveau());
            
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
