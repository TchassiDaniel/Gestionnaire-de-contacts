package com.mycompany.tp_poo.core;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Repertoire {
    private ArrayList<Contact> listeDeContact;

    public Repertoire() {
        listeDeContact = new ArrayList<Contact>();
    }

    public Repertoire(ArrayList<Contact> listeDeContact) {
        this.listeDeContact = listeDeContact;
    }

    public ArrayList<Contact> getListeDeContact() {
        return listeDeContact;
    }

    public void setListeDeContact(ArrayList<Contact> listeDeContact) {
        this.listeDeContact = listeDeContact;
    }
    
    public void ajouterUnContact(Contact cont){
        listeDeContact.add(cont);
    }
    
    
    public void supprimerUnContact(Contact cont){
            int i =0;
        for(Contact contactInList : this.listeDeContact){
            if(cont.getCode().equals(contactInList.getCode())){
                this.listeDeContact.remove(i);
            }
            i++;

        }
    }
    
    public void modifierUnContact(String code, String nom, Date dateDeNaissance, String adresse, String email, String telNumber){
        int i =0;
        for(Contact contactInList : this.listeDeContact){
            if(code.equals(contactInList.getCode())){
                Contact personne = this.listeDeContact.get(i);
                personne.setAdresse(adresse);
                personne.setDateDeNaissance(dateDeNaissance);
                personne.setEmail(email);
                personne.setNom(nom);
                personne.setTelNumber(telNumber);
            }
            i++;

        }
    }
    
    public Contact rechercherContact(String code){
        int i =0;
        for(Contact contactInList : this.listeDeContact){
            if(code.equals(contactInList.getCode())){
                return this.listeDeContact.get(i);
            }
            i++;

        }
        return null;
    }
}
