/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "save_trans", urlPatterns = {"/save_trans"})
public class save_trans extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

            String uid = request.getParameter("uid");
            String cid = request.getParameter("cid");
            String nost = request.getParameter("nost");
            String sprice = request.getParameter("sprice");
            String total = request.getParameter("total");
            String typ = request.getParameter("typ");
            String bal = request.getParameter("bal");

            try {

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {

                int times = 0;
                String groups = "";
                ResultSet rss = DB.search("SELECT times,groupg FROM users WHERE username='" + uid + "'");
                while (rss.next()) {
                    times = rss.getInt(1);
                    groups = rss.getString(2);
                }

                if (times <= 0) {
                    out.write("over");
                } else {
                    times--;
                    ResultSet rs = DB.search("SELECT * FROM user_share WHERE user = '" + uid + "' AND company = '" + cid + "'");
                    if (rs.next()) {
                        int tots = Integer.parseInt(rs.getString(3)) + Integer.parseInt(nost);
                        DB.Execute("UPDATE user_share SET `shares` = '" + tots + "' WHERE `user` = '" + uid + "' AND `company` = '" + cid + "'");
                    } else {
                        DB.Execute("INSERT INTO user_share VALUES ('" + uid + "','" + cid + "','" + nost + "')");
                    }
                    DB.Execute("INSERT INTO trans VALUES('" + uid + "','" + cid + "','" + nost + "','" + sprice + "','" + total + "','" + bal + "','" + typ + "','" + sdf.format(new Date()) + "','" + groups + "')");
                    DB.Execute("UPDATE users SET acc_bal='" + bal + "',times='" + times + "' WHERE username='" + uid + "'");
                    System.out.println(uid);
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
