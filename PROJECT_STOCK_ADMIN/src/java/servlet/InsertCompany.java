/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.DB;

/**
 *
 * @author Nalaranga
 */
@WebServlet(name = "InsertCompany", urlPatterns = {"/InsertCompany"})
public class InsertCompany extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                String comp_id = request.getParameter("comp_id");
                String comp_name = request.getParameter("comp_name");
                String stock_price = request.getParameter("stock_price");
                String stocks=request.getParameter("stocks");
                String sell_price=request.getParameter("sell_price");
                
                
                
                DB.Execute("INSERT INTO comp_tr (comp_id,comp_name,stock_price,stocks) VALUES  ('" + comp_id + "','" + comp_name + "' ,'" + stock_price + "','" + stocks + "')");
                
                out.println("Save Suceefully");
                //response.sendRedirect("/PROJECT_STOCK/CreateUser.jsp");
                
                out.println("<script type=\"text/javascript\">");
                out.println("location='home.jsp';");
                out.println("alert('Save Suceefully');");
                out.println("</script>");
            } catch (Exception e) {
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
