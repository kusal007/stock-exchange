/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.OnlineUsersCounter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet"},
        initParams = {
            @WebInitParam(name = "user", value = "Jonty")})
public class HelloWorldServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        session.setMaxInactiveInterval(60);

        try {
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>Number of Users Online : "
                    + OnlineUsersCounter.getNumberOfUsersOnline()
                    + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

}
