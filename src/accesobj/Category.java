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
public class Category {
    private Short categoryId;
    private String name;
    private Date lastUpdate;
    
    
    public Category(Short id, String name, Date lastUpdate){
        this.setCategoryId(id);
        this.setName(name);
        this.setLastUpdate(lastUpdate);
    }
    
    public final void setCategoryId(Short id){
        if(id == null){
            throw new IllegalArgumentException("Must not be NULL");
        }
        this.categoryId = id;
    }
    
     public final void  setName(String name){
        if(name == null){
            throw new IllegalArgumentException("Must not be NULL");
        }
        this.name = name;
    }
        
    public final void setLastUpdate(Date date){
        if(date == null){
            throw new IllegalArgumentException("Must not be NULL");
        }
        this.lastUpdate = date;
    }
    
    public Short getId(){
        return this.categoryId;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Date getLastUpdate(){
        return this.lastUpdate;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
