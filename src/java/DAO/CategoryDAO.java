/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.connection;
import Modal.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fattt
 */
public class CategoryDAO extends DBConnect{
    //    Get All Category
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getString("categoryID"),
                        rs.getString("name")
                );
                list.add(category);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        CategoryDAO hsd = new CategoryDAO();
//        List<Category> list = hsd.getAllCategory();
//        System.out.println(list.get(0).getName());
//    }
    
    //    Add category
    public void addCategory(Category c){
        String sql = "insert into category values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryID());
            st.setString(2, c.getName());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //    Find category by id
    public Category getCategoryById(String categoryID){
        String sql = "select * from category where categoryID=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, categoryID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Category c = new Category(
                        rs.getString("categoryID"),
                        rs.getString("name")
                );
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
        
//    Delete a category
    public void deleteCategory(String categoryID){
        String sql = "DELETE FROM category WHERE categoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, categoryID);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //    Update category
    public void updateCategory(Category c){
        String sql = "UPDATE category SET "
                + "categoryID = ?,"
                + "name = ?"
                + "WHERE categoryID = ?;";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryID());
            st.setString(2, c.getName());
            st.setString(3, c.getCategoryID());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
}
