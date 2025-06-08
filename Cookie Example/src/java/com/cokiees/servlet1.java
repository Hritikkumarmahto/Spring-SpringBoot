package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet1", urlPatterns = {"/servlet1"}) 
public class servlet1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            
            String name = request.getParameter("name");
            
            if (name == null || name.isEmpty()) {
                out.println("<h2>Please provide a valid name!</h2>");
                return;
            }

            out.println("<h1>Hello, welcome to my website " + name + "!</h1>");
            out.println("<h1><a href='servlet2'>Go to servlet 2</a></h1>");

            // Create cookie
            Cookie c = new Cookie("user_name", name);
            c.setPath("/"); // Make cookie available across the entire application
            c.setHttpOnly(true); // Security enhancement
            response.addCookie(c);

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet1 creates a cookie and redirects to Servlet2";
    }
}
