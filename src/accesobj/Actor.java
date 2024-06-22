/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesobj;

import java.util.Date;

/**
 *
 * @author prakxo
 */
public class Actor {
    private Short actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public Actor(Short actorId, String firstName, String lastName, Date lastUpdate) {
        this.setActorId(actorId);
        this.setFirstName(firstName);
        this.setLastName(lastName); 
        this.setLastUpdate(lastUpdate);  
    }
    
    
    public final void setActorId(Short actorId) {
        if(actorId==null)
            throw new IllegalArgumentException("Must not be NULL");
        this.actorId = actorId;
    }

    public final void setFirstName(String firstName) {
        if(firstName==null)
            throw new IllegalArgumentException("Must not be NULL");
        this.firstName = firstName;
    }

    public final void setLastName(String lastName) {
        if(lastName==null)
            throw new IllegalArgumentException("Must not be NULL");
        this.lastName = lastName;
    }

    public final void setLastUpdate(Date lastUpdate) {
        if(lastUpdate==null)
            throw new IllegalArgumentException("Must not be NULL");
        this.lastUpdate = lastUpdate;
    } 
    
    public Short getId(){
        return this.actorId;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public Date getLastUpdate(){
        return this.lastUpdate;
    }
    
    
    @Override
    public String toString(){
        return this.firstName + this.lastName;
    }
    
    
}
