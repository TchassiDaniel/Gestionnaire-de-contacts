/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp_poo;

import com.mycompany.tp_poo.IHM.ListeDesContacts;
import com.mycompany.tp_poo.core.Contact;
import com.mycompany.tp_poo.core.Repertoire;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class MainApplication{

    public static void main(String[] args) {
        Repertoire repertoire = new Repertoire();
        
        //Contact c1 = new Contact("AZER", "Tchassi Daniel", Date.from(Instant.now()), "Yaoundé", "tchassidaniel@gmail.com", "+237650829890");
        //repertoire.ajouterUnContact(c1);
        for(Contact c : repertoire.getListeDeContact()){
            System.out.println(c.getEmail());
        }
    }
}
