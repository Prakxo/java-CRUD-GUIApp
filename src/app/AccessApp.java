/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.sql.SQLException;
import ui.MainEd;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


import acessdata.DataMan;

/**
 *
 * @author prakxo
 */
public class AccessApp {
    public static void main(String[] args) {
        MainEd mainEd = null;

        try {
            mainEd = new MainEd();
        } catch (SQLException e) {
            System.out.println("Error ... " + e.getMessage() + "\n");
            return;
        }
        
        
        mainEd.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(WindowEvent ev) {
                if(DataMan.connectionEnabled())
                    DataMan.getInstance().close();
            }
            @Override
            public void windowOpened(WindowEvent ev) {

            }        

            @Override
            public void windowClosed(WindowEvent ev) {

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
        
        mainEd.setVisible(true);
    }
    
    
}
