/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.connection;
import Modal.Item;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fattt
 */
public class ItemDAO extends DBConnect{
//    Get all item
    public List<Item> getAllItem(){
        List<Item> list = new ArrayList<>();
        String sql = "select * from item";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                rs.getString("itemID"),
                rs.getString("name"),
                rs.getInt("stock"),
                rs.getDouble("costPrice"),
                rs.getDouble("sellPrice"),
                rs.getString("image"),
                rs.getString("description"),
                rs.getString("categoryID")
            );
            list.add(item);
        }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        ItemDAO hsd = new ItemDAO();
//        List<Item> list = hsd.getAllItem();
//        System.out.println(list.get(0).getName());
//    }
    
//    Add item
    public void addItem(Item item){
        String sql = "insert into item values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, item.getItemID());
            st.setString(2, item.getName());
            st.setInt(3, item.getStock());
            st.setDouble(4, item.getCostPrice());
            st.setDouble(5, item.getSellPrice());
            st.setString(6, item.getImage());
            st.setString(7, item.getDescription());
            st.setString(8, item.getCategoryID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    Get item by id
    public Item getItemById(String itemID){
        String sql = "select * from item where itemID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, itemID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               Item item = new Item(
                rs.getString("itemID"),
                rs.getString("name"),
                rs.getInt("stock"),
                rs.getDouble("costPrice"),
                rs.getDouble("sellPrice"),
                rs.getString("image"),
                rs.getString("description"),
                rs.getString("categoryID")
            );
               return item;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
//    public static void main(String[] args) {
//        ItemDAO hsd = new ItemDAO();
//        System.out.println();
//        hsd.deleteItem("it01");
//    }
    
//    Delete item
    public void deleteItem(String itemID){
        String sql = "DELETE FROM item WHERE itemID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, itemID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    Update item
    public void updateItem(Item item){
       String sql = "UPDATE item SET "
            + "name = ?,"
            + "stock = ?,"
            + "costPrice = ?,"
            + "sellPrice = ?,"
            + "image = ?,"
            + "description = ?,"
            + "categoryID = ?"
            + "WHERE itemID = ?;"; 
       
        try {
           PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, item.getName());
            st.setInt(2, item.getStock());
            st.setDouble(3, item.getCostPrice());
            st.setDouble(4, item.getSellPrice());
            st.setString(5, item.getImage());
            st.setString(6, item.getDescription());
            st.setString(7, item.getCategoryID());
            st.setString(8, item.getItemID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
