/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import acessdata.ActorDAO;
import acessdata.DataMan;
import accesobj.Actor;

import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author samalv
 */
public class DeleteActorUI extends javax.swing.JFrame {

    /**
     * Creates new form DeleteActorUI
     */
    public DeleteActorUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonEv(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonEv(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonEv(evt);
            }
        });

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(firstNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(deleteButton)
                        .addGap(38, 38, 38)
                        .addComponent(clearButton)
                        .addGap(29, 29, 29)
                        .addComponent(cancelButton)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(clearButton)
                    .addComponent(cancelButton))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonEv
        this.firstNameField.setText("");
        this.lastNameField.setText("");
    }//GEN-LAST:event_clearButtonEv

    private void cancelButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonEv
        this.dispose();
    }//GEN-LAST:event_cancelButtonEv

    private void deleteButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonEv
        String firstName = DataMan.getInstance().getNonNULLStr(this.firstNameField.getText());
        String lastName = DataMan.getInstance().getNonNULLStr(this.lastNameField.getText());
        
        int value = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete Actor?","Delete Actor",JOptionPane.YES_NO_OPTION);
        
        
        if(value == JOptionPane.YES_OPTION){
            if(firstName != null && lastName != null){
                try{
                    Actor del = DataMan.getInstance().findActorByFullName(firstName, lastName);

                    if(del != null){
                        DataMan.getInstance().deleteActor(del);
                        JOptionPane.showMessageDialog(this, "Actor deleted succesfully", "!", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Actor not found to delete", "Error!", JOptionPane.ERROR_MESSAGE);
                        throw new IllegalArgumentException("Must have value");
                    }
                }catch(SQLException e){
                    
                    if(e.getSQLState().equals("23000") == true){
                        JOptionPane.showMessageDialog(this, "Can't remove Actor that is referenced in other tables \n", "Error!", JOptionPane.ERROR_MESSAGE);

                        System.out.println("Error ... Can't remove Actor that is referenced in other tables \n");
                    }
                    else{
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);

                        System.out.println("Error ... " + e.getMessage() + "\n");

                    }
                }
            }
        }
    }//GEN-LAST:event_deleteButtonEv

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField lastNameField;
    // End of variables declaration//GEN-END:variables
}