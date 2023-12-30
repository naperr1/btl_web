/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.connection;
import Modal.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fattt
 */
public class UserDAO extends DBConnect{
    //    Get All Customer
    public List<User> getAllCustomer() {
        List<User> list = new ArrayList<>();
        String sql = "select * from user";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getString("userID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("role")
                        
                );
                list.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    //    Add user
    public void addUser(User c){
        String sql = "insert into user values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUserID());
            st.setString(2, c.getUsername());
            st.setString(3, c.getPassword());
            st.setString(4, c.getFullname());
            st.setString(5, c.getAddress());
            st.setString(6, c.getEmail());
            st.setString(7, c.getPhone());
            st.setInt(8, c.getRole());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //    Find user by id
    public User getCustomerById(String userID){
        String sql = "select * from user where userID=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                User user = new User(
                        rs.getString("userID"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("role")
                        
                );
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    //    Delete a custormer
    public void deleteUser(String userID){
        String sql = "DELETE FROM user WHERE userID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userID);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //    Update category
    public void updateCustomer(User c){
        String sql = "UPDATE user SET "
                            + "userID = ?,"
                            + "username = ?,"
                            + "password = ?,"
                            + "fullname = ?,"
                            + "email = ?,"
                            + "address = ?,"
                            + "phone = ?,"
                            + "role = ? "
                            + "WHERE userID = ?;";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUserID());
            st.setString(2, c.getUsername());
            st.setString(3, c.getPassword());
            st.setString(4, c.getFullname());
            st.setString(5, c.getAddress());
            st.setString(6, c.getEmail());
            st.setString(7, c.getPhone());
            st.setInt(8, c.getRole());
            st.setString(9, c.getUserID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
