/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prakxo
 */
public class NotEditableTableModel extends DefaultTableModel{
    
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
}
