/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.ItemDAO;
import Modal.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fattt
 */
@WebServlet(name="UpdateItem", urlPatterns={"/updateItem"})
public class UpdateItem extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateItem</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateItem at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String itemID = request.getParameter("itemID");
        ItemDAO itd = new ItemDAO();
        try {
            Item item = itd.getItemById(itemID);
            request.setAttribute("item", item);
            request.getRequestDispatcher("updateItem.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String itemID = request.getParameter("itemID");
        String name = request.getParameter("name");
        String stock_raw = request.getParameter("stock");
        String costPrice_raw = request.getParameter("costPrice");
        String sellPrice_raw = request.getParameter("sellPrice");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String categoryID = request.getParameter("categoryID");
        
        int stock;
        double costPrice, sellPrice;
        ItemDAO itd = new ItemDAO();
        
        try {
            stock = Integer.parseInt(stock_raw);
            costPrice = Double.parseDouble(costPrice_raw);
            sellPrice = Double.parseDouble(sellPrice_raw);
            Item item = new Item(itemID, name, stock, costPrice, sellPrice, image, description, categoryID);
            itd.updateItem(item);
            response.sendRedirect("listItemManager");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
