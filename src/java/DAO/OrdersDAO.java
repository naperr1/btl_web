/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.connection;
import Modal.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr.Thai
 */
public class OrdersDAO extends DBConnect{
    public List<Order> getAllOrders(){
        List<Order> list = new ArrayList<>();
        String sql = "select orderID, username, orderDate, totalMoney, status\n" +
                        "from " + databaseName + ".order, user\n" +
                            "where userID_order = userID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();           
            while (rs.next()) {
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                Order order = new Order(
                rs.getString("orderID"),
                rs.getString("username"),             
                rs.getDouble("totalMoney"),
                status,
                rs.getString("orderDate")           
            );
            list.add(order);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
//    public static void main(String[] args) {
//        OrdersDAO odd = new OrdersDAO();
//        List<Order> list = odd.getAllOrders();
//        System.err.println(list.get(2).getUserName());
//    }
}
