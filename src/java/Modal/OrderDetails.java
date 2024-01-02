/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author Mr.Thai
 */
public class OrderDetails {
    private String orderID, username, fullname, phone, orderDate, status;
    private double totalMoney;
    
    public OrderDetails() {
        
    }
    public OrderDetails(String orderID, String username, String fullname, String phone, String orderDate, String status, double totalMoney) {
        this.orderID = orderID;
        this.username = username;
        this.fullname = fullname;
        this.phone = phone;
        this.orderDate = orderDate;
        this.status = status;
        this.totalMoney = totalMoney;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    
}
