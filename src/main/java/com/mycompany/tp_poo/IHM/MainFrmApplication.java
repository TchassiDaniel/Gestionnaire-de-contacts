/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tp_poo.IHM;

import com.mycompany.tp_poo.core.Agent;
import com.mycompany.tp_poo.core.Contact;
import com.mycompany.tp_poo.core.Enseignant;
import com.mycompany.tp_poo.core.Etudiant;
import com.mycompany.tp_poo.core.Repertoire;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class MainFrmApplication extends javax.swing.JFrame {

    private Connection conn;
    private Repertoire repertoire;
    /**
     * Creates new form MainFrmApplication
     */
    public MainFrmApplication() {
        repertoire = new Repertoire();
        try {
            //Connection à la BD
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_poo","root", "");
            this.chargerRepertoire(conn);
       
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrmApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La connexion à la base de donnée à echouer vous allez travaillez hors ligne", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        }
         initComponents();
    }
    private void enregistrer(){
        if(conn == null){
            JOptionPane.showMessageDialog(null, "La connexion à la base de donnée à echouer vous allez travaillez hors ligne", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(Contact c : repertoire.getListeDeContact()){
            c.ajouterALaBD(conn);
        }
    }
    
    private void chargerRepertoire(Connection conn){
        repertoire = new Repertoire();
        try{
            //On lis la table des Etudiants pour remplir le repertoire
            Statement st = conn.createStatement();
            String query ="select code, nom, dateDeNaissance, adress, email, "
                    + "telNumber, cycle, niveau from etudiant";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Etudiant et = new Etudiant();
                et.setCode(rs.getString("code"));
                et.setNom(rs.getString("nom"));
                et.setDateDeNaissance(rs.getDate("dateDeNaissance"));
                et.setAdresse(rs.getString("adress"));
                et.setEmail(rs.getString("email"));
                et.setTelNumber(rs.getString("telNumber"));
                et.setCycle(rs.getString("cycle"));
                et.setNiveau(rs.getInt("niveau"));
                repertoire.ajouterUnContact(et);
            }
            
            //On lis la table des Enseignants pour remplir le tableau
            st = conn.createStatement();
            query ="select code, nom, dateDeNaissance, adress, email, "
                    + "telNumber, statut from enseignant";
            rs = st.executeQuery(query);
            while(rs.next()){
                Enseignant et = new Enseignant();
                et.setCode(rs.getString("code"));
                et.setNom(rs.getString("nom"));
                et.setDateDeNaissance(rs.getDate("dateDeNaissance"));
                et.setAdresse(rs.getString("adress"));
                et.setEmail(rs.getString("email"));
                et.setTelNumber(rs.getString("telNumber"));
                et.setStatut(rs.getString("statut"));
                repertoire.ajouterUnContact(et);
            } 
            
                //On lis la table des Agents pour remplir le tableau
            st = conn.createStatement();
            query ="select code, nom, dateDeNaissance, adress, email, telNumber, "
                    + "salaire, statut, categorie, indiceDeSalaire, occupation from agent";
            rs = st.executeQuery(query);
                while(rs.next()){
                Agent et = new Agent();
                et.setCode(rs.getString("code"));
                et.setNom(rs.getString("nom"));
                et.setDateDeNaissance(rs.getDate("dateDeNaissance"));
                et.setAdresse(rs.getString("adress"));
                et.setEmail(rs.getString("email"));
                et.setTelNumber(rs.getString("telNumber"));
                et.setSalaire(rs.getDouble("salaire"));
                et.setStatut(rs.getString("statut"));
                et.setCategorie(rs.getString("Categorie"));
                et.setIndiceDeSalaire(rs.getString("indiceDeSalaire"));
                et.setOccupation(rs.getString("occupation"));
                repertoire.ajouterUnContact(et);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MainFrmApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        afficherContactButton = new javax.swing.JButton();
        creerContactButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        afficherContactButton.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        afficherContactButton.setText("Aficher les contacts");
        afficherContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afficherContactButtonActionPerformed(evt);
            }
        });

        creerContactButton.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        creerContactButton.setText("Créer un contact");
        creerContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creerContactButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionnaire de contacts");

        jMenu1.setText("Fichier");

        jMenuItem1.setText("Enregistrer");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(creerContactButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(afficherContactButton, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(creerContactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(afficherContactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afficherContactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afficherContactButtonActionPerformed
        if(conn != null)
            this.chargerRepertoire(conn);
        Frame afficherContactFrame = new ListeDesContacts(this.repertoire, this);
        afficherContactFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_afficherContactButtonActionPerformed

    private void creerContactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creerContactButtonActionPerformed
        Frame creerContactFrame = new CreerUnContact(this.repertoire, this);
        creerContactFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_creerContactButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       this.enregistrer();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrmApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrmApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrmApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrmApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrmApplication().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afficherContactButton;
    private javax.swing.JButton creerContactButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
