/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acessdata;

import accesobj.Actor;
import accesobj.Category;


import static global.Global.*;

import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author prakxo
 */
public class DataMan implements AutoCloseable {
    private static String dataBaseUser = DEFAULT_DATA_BASE__USER;
    private static String dataBasePwd = DEFAULT_DATA_BASE__PWD;
    private static String dataBaseURL = DEFAULT_DATA_BASE__URL;

    private static DataMan singleton;

    private Connection con;
    
    private ActorDAO actor;
    private CategoryDAO category;

    private DataMan() {}

    public static DataMan getInstance() {
        if (singleton == null) {
            loadDataBaseParams();
            singleton = new DataMan();

            
            try {
                singleton.con = createConnection();              
                singleton.actor = new ActorDAO(singleton.con);
                singleton.category = new CategoryDAO(singleton.con);
            } catch (Exception e) {
                singleton = null;
                throw new RuntimeException(e);
            }
        }
        return singleton;
    }
    
    public static boolean connectionEnabled(){
        return singleton != null;
    }

    private static Connection createConnection() {
        try {
            Class.forName(MYSQL_DB_DRIVER__CLASS_NAME);
            Connection cnt = DriverManager.getConnection(dataBaseURL, dataBaseUser, dataBasePwd);
            cnt.setAutoCommit(false);
            return cnt;
        } catch (ClassNotFoundException cnfe) {
            System.out.print("Driver not found\n" + cnfe.getMessage());
            return null;
        } catch (SQLException sqle) {
            StringBuilder sb = new StringBuilder()
                                   .append("There's a problem in the DataBase. ")
                                   .append("Look out for: \n")
                                   .append("\t- Having MySQL server up.\n")
                                   .append("\t- Having Sakila database set up.\n")
                                   .append("\t- Config file resources/db.properties is correct.\n")
                                   .append("Error: ")
                                   .append(sqle.getMessage());
            System.out.println(sb.toString());
            return null;
        }
    }
    
    private static void loadDataBaseParams() {
        
        Properties pDataBaseConfiguration = null;
        FileReader dbReaderStream = null;
        try{
            dbReaderStream = new FileReader(DB_CONFIG__FILE_NAME);
            pDataBaseConfiguration = new Properties();
            pDataBaseConfiguration.load(dbReaderStream); 
        }
        catch(IOException e){
            System.out.println("Error loading config file. " + e.getMessage());
            
        }
        finally{
            try{
                if(dbReaderStream!=null)
                    dbReaderStream.close();
            }
            catch(IOException ioe){
                System.out.println("Error closing read of config file " + ioe.getMessage());
            }
        }
        
        if(pDataBaseConfiguration!=null){
            if(pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY)!=null)
                dataBaseUser = pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY);
            if(pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY)!=null)
                dataBasePwd = pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY);
            if(pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY)!=null)
                dataBaseURL = pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY);
        }
    }
    

    @Override
    public void close() {
        try {
            if(con != null && !con.isClosed()){
                con.close();
                actor = null;
                category = null;
            }
        } catch (SQLException sqe) {
            System.out.println("Error closing connection. " + sqe.getMessage());
        } finally {
            singleton = null;
        }
    }
    
    public List<Actor> loadAllActors() throws SQLException {
        return this.actor.loadAllActors();
    }
    
    public List<Actor> loadActorByFirstName(String name) throws SQLException {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Must have a value to search");
        }
        
        return this.actor.loadActorByFirstName(name);
    } 
    
    public List<Actor> loadActorByLastName(String name) throws SQLException {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Must have a value to search");
        }
        
        return this.actor.loadActorByLastName(name);
    } 
    
    public Actor findActorByFullName(String firstName, String lastName) throws SQLException {
        if(firstName == null && lastName == null){
            throw new IllegalArgumentException("Must have values");
        }
        return this.actor.findActorByFullName(firstName,lastName);
    }
    
    public void updateActor(Actor actor) throws SQLException{
        if(actor == null){
            throw new IllegalArgumentException("Actor can't be empty");
        }
        
        this.actor.updateActor(actor.getId(), actor.getFirstName(), actor.getLastName());
    }
    
    public void deleteActor(Actor actor) throws SQLException {
        if(actor == null){
            throw new IllegalArgumentException("Must have a value");
        }
        
        this.actor.deleteActor(actor.getId());
        
    }
    
    public Actor insertActor(String firstName, String lastName) throws SQLException {
        if(firstName == null || firstName.length() == 0 || lastName == null || lastName.length() == 0){
            throw new IllegalArgumentException("Not enough values");
        }
        
        return this.actor.insertActor(firstName, lastName);
    }
    
    
    public List<Category> loadAllCategories() throws SQLException {
        return this.category.loadAllCategories();
    }
    
    public Category loadCategoryByName(String name) throws SQLException {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Must have value");
        }
        return this.category.loadCategoryByName(name);
    }
    
    public void deleteCategory(Category cat) throws SQLException {
        if(cat == null){
            throw new IllegalArgumentException("Must have a value");
        }
        
        this.category.deleteCategory(cat.getId());
        
    }
   
    public void updateCategory(Category cat) throws SQLException{
        if(cat == null){
            throw new IllegalArgumentException("Category can't be empty");
        }
        
        this.category.updateCategory(cat.getId(), cat.getName());
    }
    
    public Category insertCategory(String name) throws SQLException {
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("Not enough values");
        }
        
        return this.category.insertCategory(name);
    }
    
    public String getNonNULLStr(String str){
        if(str.equals("")){
            return null;
        }
        return str;
    }
}
