/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.DBConnect.connection;
import Modal.Order;
import Modal.OrderDetails;
import Modal.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
    
      public OrderDetails getOrderDetailsById(String orderID) {   
          String sql = "select orderID, username, user.fullname, user.phone, orderDate, totalMoney, status\n" +
                        "from " + databaseName +".order, user\n" +
                        "where orderID = ?\n" +
                        "and userID_order = userID";
        try {      
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                OrderDetails order = new OrderDetails(
                    rs.getString("orderID"), 
                    rs.getString("username"), 
                    rs.getString("fullname"), 
                    rs.getString("phone"), 
                    rs.getString("orderDate"), 
                    status,
                    rs.getDouble("totalMoney"));
                return order;  
            }
                 
        } catch(Exception e) {   
            System.out.println(e);
        }
        return null;
      }
      public Order getOrderById(String orderID){
        String sql = "select orderID, username, orderDate, totalMoney, status\n" +
                        "from " + databaseName + ".order, user\n" +
                            "where userID_order = userID and orderID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                Order od = new Order(
                rs.getString("orderID"),
                rs.getString("username"),
                rs.getDouble("totalMoney"),
                status,
                rs.getString("orderDate")
            );
               return od;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     public void updateOrder(Order order){
       String sql = "UPDATE " + databaseName + ".order SET \n"
            + "totalMoney = ?,\n"
            + "orderDate = ?,\n"
            + "status = ?\n"
            + "WHERE orderID = ?;"; 
       
        try {
           PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, order.getTotalMoney());
            st.setString(2, order.getOrderDate());
            
            int status = 1;
            if("Shipping".equals(order.getStatus()))
                status = 2;
            else if("Completed".equals(order.getStatus()))
                status = 3;
            st.setInt(3, status);
            st.setString(4, order.getOrderID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     public List<OrderItem> getOrderItemByOrderId(String orderID) {
         List<OrderItem> list = new ArrayList<OrderItem>();
         String sql = "SELECT image, name, sellPrice, quantity\n" +
                        "from orderitem, item\n" +
                        "where orderID_orderItem = ?" +
                            "and itemID_orderItem = itemID";
         try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                double total = rs.getDouble("sellPrice") * rs.getInt("quantity");
                 DecimalFormat df = new DecimalFormat("#.##");
                 String formattedNumber = df.format(total);
                 double totalNumber = Double.parseDouble(formattedNumber);
                OrderItem odi = new OrderItem(
                        rs.getString("image"), 
                        rs.getString("name"), 
                        rs.getDouble("sellPrice"),                      
                        rs.getInt("quantity"),
                        totalNumber);
                list.add(odi);
            }
         } catch(Exception e) {
            System.out.println(e); 
         }
         return list;
     }
}
