/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author Mr.Thai
 */
public class Order {
    private String orderID, username;
    private double totalMoney;
    private String status;
    private String orderDate;

    public Order(String orderID, String username, double totalMoney, String status, String date) {
        this.orderID = orderID;
        this.username = username;
        this.totalMoney = totalMoney;
        this.status = status;
        this.orderDate = date;
    }

    public String getOrderID() {
        return orderID;
    }
    
    public String getOrderDate() {
        return orderDate;
    }

    public String getUsername() {
        return username;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }


    public void setStatus(String status) {
        this.status = status;
    }
    public void SetOrderDate(String date) {
        this.orderDate = date;
    }
    
}
