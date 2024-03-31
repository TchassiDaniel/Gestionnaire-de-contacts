
package com.mycompany.tp_poo.core;

import java.sql.Connection;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public abstract class Contact {
    private String code;
    private String nom;
    private Date dateDeNaissance;
    private String adresse;
    private String email;
    private String telNumber;

    public Contact() {
    }

    public Contact(String code, String nom, Date dateDeNaissance, String adresse, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.email = email;
        this.telNumber = telNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    
    public abstract void ajouterALaBD(Connection conn);
}
