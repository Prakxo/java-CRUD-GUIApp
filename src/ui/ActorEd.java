/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import acessdata.ActorDAO;
import acessdata.DataMan;
import accesobj.Actor;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author prakxo
 */
public class ActorEd extends javax.swing.JFrame {
    private final static SimpleDateFormat LAST_UPDATED_STRING_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private InsertActorUI insert;
    private DeleteActorUI delete;
    private UpdateActorUI update;
    
    /**
     * Creates new form ActorEd
     */
    public ActorEd() {
        try {
        initComponents();
        
        loadActorData();
        
        this.actorList.setCellSelectionEnabled(false);
        this.actorList.setRowSelectionAllowed(false);
        this.actorList.setColumnSelectionAllowed(false);
        } catch (SQLException e) {
            System.out.println("Error ... " + e.getMessage() + "\n");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        actorList = new javax.swing.JTable();
        reloadButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();

        setTitle("Actor Editor");
        setResizable(false);

        actorList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Last Name", "Timestamp"
            }
        ));
        jScrollPane1.setViewportView(actorList);
        if (actorList.getColumnModel().getColumnCount() > 0) {
            actorList.getColumnModel().getColumn(1).setResizable(false);
        }

        reloadButton.setText("Reload");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadEv(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonEv(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActorEv(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonEv(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonEv(evt);
            }
        });

        firstNameLabel.setText("First Name");

        lastNameLabel.setText("Last Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reloadButton)
                .addGap(18, 18, 18)
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(15, 15, 15)
                .addComponent(updateButton)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton))
                    .addComponent(lastNameLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(firstNameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloadButton)
                    .addComponent(updateButton)
                    .addComponent(insertButton)
                    .addComponent(deleteButton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reloadEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadEv
        DefaultTableModel table = new NotEditableTableModel();
        this.actorList.setModel(table);
        
        try {
            loadActorData();
        } catch (SQLException e) {
            System.out.println("Error ... " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_reloadEv

    private void insertActorEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActorEv
        if(insert == null){
            insert = new InsertActorUI();
        }
        
        ActorEd actor = this;
        
        actor.setEnabled(false);



        
        insert.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent ev) {

            }
            @Override
            public void windowOpened(WindowEvent ev) {
            }        

            @Override
            public void windowClosed(WindowEvent ev) {
                actor.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent ev) {

            }

            @Override
            public void windowDeiconified(WindowEvent ev) {

            }

            @Override
            public void windowActivated(WindowEvent ev) {

            }

            @Override
            public void windowDeactivated(WindowEvent ev) {

            }
            
        });
        
        insert.setVisible(true);

        
    }//GEN-LAST:event_insertActorEv

    private void deleteButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonEv
        if(delete == null){
            delete = new DeleteActorUI();
        }
        
        ActorEd actor = this;
        
        actor.setEnabled(false);
        

        
        delete.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent ev) {

            }
            @Override
            public void windowOpened(WindowEvent ev) {
            }        

            @Override
            public void windowClosed(WindowEvent ev) {
                actor.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent ev) {

            }

            @Override
            public void windowDeiconified(WindowEvent ev) {

            }

            @Override
            public void windowActivated(WindowEvent ev) {

            }

            @Override
            public void windowDeactivated(WindowEvent ev) {

            }
            
        });
        
        delete.setVisible(true);
    }//GEN-LAST:event_deleteButtonEv

    private void updateButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonEv
        if(update == null){
            update = new UpdateActorUI();
        }
        
        ActorEd actor = this;
        
        actor.setEnabled(false);
        
        update.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent ev) {

            }
            @Override
            public void windowOpened(WindowEvent ev) {
            }        

            @Override
            public void windowClosed(WindowEvent ev) {
                actor.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent ev) {

            }

            @Override
            public void windowDeiconified(WindowEvent ev) {

            }

            @Override
            public void windowActivated(WindowEvent ev) {

            }

            @Override
            public void windowDeactivated(WindowEvent ev) {

            }
            
        });
        
        update.setVisible(true);
    }//GEN-LAST:event_updateButtonEv

    private void searchButtonEv(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonEv
        String firstName = DataMan.getInstance().getNonNULLStr(this.firstNameField.getText());
        String lastName = DataMan.getInstance().getNonNULLStr(this.lastNameField.getText());
        
        try{
            loadActorBySearch(firstName,lastName);
        }
        catch(SQLException e){
            System.out.println("Error ... " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_searchButtonEv



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable actorList;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JButton insertButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton reloadButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    
    private int __checkSearchType(String str1, String str2){
        if(str1 == null && str2 == null){
            return 0;
        }
        else if(str1 != null && str2 == null){
            return 1;
        }
        else if(str1 == null && str2 != null){
            return 2;
        }
        else{
            return 3;
        }
    }

    private void loadActorBySearch(String firstName, String lastName) throws SQLException {
        int i;
        Object tableRowCont[] = new Object[4];
        List<Actor> list = new ArrayList<Actor>();
        
        int type = __checkSearchType(firstName, lastName);
        
        switch(type){
            case 0:

                break;
            case 1:
                list = DataMan.getInstance().loadActorByFirstName(firstName);
                break;
            case 2:
                list = DataMan.getInstance().loadActorByLastName(lastName);
                break;
            case 3:
                Actor act = DataMan.getInstance().findActorByFullName(firstName, lastName);
                
                if(act != null){
                    list.add(act);
                }
                break;
            default:
                break;
        }
        
        DefaultTableModel table = new NotEditableTableModel();
        
        table.addColumn("Id");
        table.addColumn("Name");
        table.addColumn("Last Name");
        table.addColumn("Timestamp");
        
        for(i = 0 ; i < list.size(); i++){
            Actor current = list.get(i);
            
            tableRowCont[0] = current.getId();
            tableRowCont[1] = current.getFirstName();
            tableRowCont[2] = current.getLastName();
            tableRowCont[3] = LAST_UPDATED_STRING_FORMAT.format(current.getLastUpdate());
            
            table.addRow(tableRowCont);
        }
        this.actorList.setModel(table);
        
    }

    private void loadActorData() throws SQLException  {
        int i;
        
        Object tableRowCont[] = new Object[4];
        
        List<Actor> list = DataMan.getInstance().loadAllActors();
        
        DefaultTableModel table = new NotEditableTableModel();
        
        table.addColumn("Id");
        table.addColumn("Name");
        table.addColumn("Last Name");
        table.addColumn("Timestamp");
        
        for(i = 0 ; i < list.size(); i++){
            Actor current = list.get(i);
            
            tableRowCont[0] = current.getId();
            tableRowCont[1] = current.getFirstName();
            tableRowCont[2] = current.getLastName();
            tableRowCont[3] = LAST_UPDATED_STRING_FORMAT.format(current.getLastUpdate());
            
            table.addRow(tableRowCont);
        }
        this.actorList.setModel(table);
    }
}