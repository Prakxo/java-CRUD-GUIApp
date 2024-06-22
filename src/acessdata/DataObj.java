/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acessdata;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author prakxo
 */
abstract public class DataObj {
    
    protected Connection con;
    
    DataObj(Connection con){
        if(con == null){
            throw new IllegalArgumentException("Must have connection\n");
        }
        
        this.con = con;
    }
}
