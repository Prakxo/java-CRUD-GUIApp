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

import accesobj.Category;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author prakxo
 */
public class CategoryDAO extends DataObj{
    
    CategoryDAO(Connection con){
        super(con);
    }
    
    protected Category readCategoryFromRes(ResultSet res) throws SQLException{
        Short categoryId = res.getShort(CategoryTableColumns.COLUMN_NAME__CATEGORY_ID);
        String name = res.getString(CategoryTableColumns.COLUMN_NAME__NAME);
        Date lastUpdate = res.getDate(CategoryTableColumns.COLUMN_NAME__LAST_UPDATE);
        
        Category cat = new Category(categoryId, name, lastUpdate);
        
        return cat;
    }
    
    protected List<Category> loadAllCategories() throws SQLException{
        List<Category> catList = new ArrayList<>();
        
        PreparedStatement st = con.prepareStatement("SELECT * FROM CATEGORY");
        
        ResultSet res = st.executeQuery();
        
        while(res.next()){
            catList.add(readCategoryFromRes(res));
        }
        
        return catList;
    }
    
    
    protected Category loadCategoryByName(String name) throws SQLException{
        Category cat = null;
        
        PreparedStatement st = con.prepareStatement("SELECT* FROM CATEGORY WHERE NAME LIKE ?");
        
        st.setString(1, name);
        
        ResultSet res = st.executeQuery();
        
        while(res.next()){
            cat = readCategoryFromRes(res);
        }
        
        
        return cat;
    }
    
    protected void deleteCategory(Short id) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM CATEGORY WHERE CATEGORY_ID = ?");
        
        st.setShort(1,id);
        
        int num = st.executeUpdate();
        
        if(num != 1){
            con.rollback();
            throw new IllegalStateException("Register hasn't been deleted");
        }
        
        con.commit();
        
    }
    
    protected void updateCategory(Short id, String name) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE CATEGORY SET NAME = ?, LAST_UPDATE = now() where CATEGORY_ID = ?");
    
        st.setString(1,name);
        
        st.setShort(2, id);
        
        int num = st.executeUpdate();
        
        if(num != 1){
            con.rollback();
            throw new IllegalStateException("Register hasn't been updated");
        }
        
        con.commit();
    }
    
    protected Category insertCategory(String name) throws SQLException {
        Category cat = null;
        
        PreparedStatement st = con.prepareStatement("INSERT INTO CATEGORY(name, last_update) VALUES(?,?)");
        
        st.setString(1,name);
        st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        
        int num = st.executeUpdate();
        
        if(num != 1){
            con.rollback();
            throw new IllegalStateException("Register hasn't been inserted");
        }
        
        st = con.prepareStatement("SELECT * FROM CATEGORY WHERE CATEGORY_ID = (SELECT MAX(CATEGORY_ID) FROM CATEGORY)");
        
        ResultSet res = st.executeQuery();
        
        while(res.next()){
            cat = readCategoryFromRes(res);
        }
        
        
        return cat;

    }
    
    
    private class CategoryTableColumns {
        private final static String COLUMN_NAME__CATEGORY_ID = "category_id";
        private final static String COLUMN_NAME__NAME = "name";
        private final static String COLUMN_NAME__LAST_UPDATE = "last_update";
    }
}
