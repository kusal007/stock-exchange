/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.DB;

/**
 *
 * @author Nishada
 */
@WebServlet(name = "get_balance", urlPatterns = {"/get_balance"})
public class get_balance extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String gid = "";
            String uid = request.getParameter("uid");

            double amount = 0;
            double opamo = 0;
            double t1 = 0;

            try {
                ResultSet rs2 = DB.search("SELECT groupg,times FROM users WHERE username='" + uid + "'");
                while (rs2.next()) {
                    gid = rs2.getString(1);

                    if (rs2.getInt(2) <= 0 && !"".equals(rs2.getString(2))) {
                        ResultSet rs = DB.search("SELECT * FROM users WHERE groupg='" + gid + "'");
                        while (rs.next()) {

                            t1 = t1 + rs.getInt(8);

                            if (rs.getString(1).equals(uid)) {
                                amount = rs.getDouble(5);
                            } else {
                                opamo = rs.getDouble(5);
                            }
                        }

                        if (amount > opamo && t1 == 0) {
                            out.write("win");
                        } else if (t1 == 0) {
                            out.write("lose");
                        }
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
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
