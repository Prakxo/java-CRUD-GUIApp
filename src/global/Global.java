/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package global;

import java.io.File;
/**
 *
 * @author prakxo
 */
public class Global {
    public final static String DB_CONFIG__FILE_NAME = "resources" + File.separator + "db.properties";
    
public final static String MYSQL_DB_DRIVER__CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    public final static String DB_CONFIG__USER_PROPERTY = "user";
    public final static String DB_CONFIG__PWD_PROPERTY = "pass";
    public final static String DB_CONFIG__URL_PROPERTY = "url";
    
    public final static String DEFAULT_DATA_BASE__USER = "tester";
    public final static String DEFAULT_DATA_BASE__PWD = "tester";
    public final static String DEFAULT_DATA_BASE__URL = "jdbc:mysql://localhost:3306/sakila";
}
