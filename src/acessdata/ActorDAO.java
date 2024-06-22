/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acessdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import accesobj.Actor;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author prakxo
 */
public class ActorDAO extends DataObj {
    
    
    ActorDAO(Connection con){
        super(con);
    }
    
    private static Actor readActorFromRes(ResultSet res) throws SQLException {
        Short actorId = res.getShort(ActorTableColumns.COLUMN_NAME__ACTOR_ID);
        String firstName = res.getString(ActorTableColumns.COLUMN_NAME__FIRST_NAME);
        String lastName = res.getString(ActorTableColumns.COLUMN_NAME__LAST_NAME);
        Date lastUpdate = res.getDate(ActorTableColumns.COLUMN_NAME__LAST_UPDATE);
        
        Actor actor = new Actor(actorId, firstName, lastName, lastUpdate);
        
        return actor;
    }
    
    protected List<Actor> loadAllActors() throws SQLException{
        List<Actor> actList = new ArrayList<>();
        
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM ACTOR");
        
        ResultSet res = st.executeQuery();
        
        
        while(res.next()){
            actList.add(readActorFromRes(res));
        }
        
        return actList;
    }
    
    protected Actor findActorByFullName(String firstName, String lastName) throws SQLException {
        Actor actor = null;
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM ACTOR WHERE FIRST_NAME = ? AND LAST_NAME = ?");
        
        st.setString(1, firstName);
        st.setString(2, lastName);
        
        ResultSet res = st.executeQuery();
        
        
        while(res.next()){
            actor = readActorFromRes(res);
        }
        
        return actor;
    }
    
    protected List<Actor> loadActorByFirstName(String firstName) throws SQLException{
        List<Actor> actList = new ArrayList<>();
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM ACTOR WHERE FIRST_NAME LIKE ?");
                
        st.setString(1, firstName);
        
        ResultSet res = st.executeQuery();
        
        while(res.next()){
            actList.add(readActorFromRes(res));
        }
        
        return actList;
    }
    
    protected List<Actor> loadActorByLastName(String lastName) throws SQLException {
        List<Actor> actList = new ArrayList<>();
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM ACTOR WHERE LAST_NAME LIKE ?");
                
        st.setString(1, lastName);
        
        ResultSet res = st.executeQuery();
        
        while(res.next()){
            actList.add(readActorFromRes(res));
        }
        
        return actList;
    }
    
    protected void deleteActor(Short id) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM ACTOR WHERE actor_id=?");
        
        st.setShort(1, id);
        
        int num = st.executeUpdate();
        
        if(num != 1){
            con.rollback();
            throw new IllegalStateException("Register hasn't been deleted");
        }
        
        con.commit();
    }
    
    protected void updateActor(Short id, String firstName, String lastName) throws SQLException {
        
        PreparedStatement st = con.prepareStatement("UPDATE ACTOR SET FIRST_NAME = ?, LAST_NAME = ?, last_update = now() WHERE ACTOR_ID = ?");
        
        st.setString(1, firstName);
        st.setString(2, lastName);
        
        st.setShort(3, id);
        
        int num = st.executeUpdate();
        if(num != 1){
            con.rollback();
            throw new IllegalStateException("Register hasn't been updated");
        }
        
        con.commit();
    }
    
    protected Actor insertActor(String firstName, String lastName) throws SQLException{
       Actor actor = null;
       PreparedStatement st = con.prepareStatement("INSERT INTO ACTOR(first_name, last_name,last_update) VALUES (?,?,?)");
       st.setString(1,firstName);
       st.setString(2,lastName);
       st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
       
       int num = st.executeUpdate();
       
       if(num != 1){
           con.rollback();
            throw new IllegalStateException("Register hasn't been inserted");

       }
       
       st = con.prepareStatement("SELECT * FROM ACTOR WHERE ACTOR_ID = (SELECT MAX(ACTOR_ID) FROM ACTOR)");
       
       ResultSet res = st.executeQuery();
       
       while(res.next()){
           actor = readActorFromRes(res);
       }
       
       con.commit();
       
       return actor;
    }
    
    
    
    private class ActorTableColumns {
        private final static String COLUMN_NAME__ACTOR_ID = "actor_id";
        private final static String COLUMN_NAME__FIRST_NAME = "first_name";
        private final static String COLUMN_NAME__LAST_NAME = "last_name";
        private final static String COLUMN_NAME__LAST_UPDATE = "last_update";
    }
}
