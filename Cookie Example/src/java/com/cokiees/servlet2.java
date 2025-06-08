package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet2", urlPatterns = {"/servlet2"})
public class servlet2 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet2</title>");
            out.println("</head>");
            out.println("<body>");
            
            Cookie[] cookies = request.getCookies();
            boolean found = false;
            String name = "";

            if (cookies == null) {
                out.println("<h1>You are new here!</h1>");
            } else {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    if ("user_name".equals(cookieName)) { // Correct comparison
                        found = true;
                        name = cookie.getValue();
                        break; // Exit the loop once the desired cookie is found
                    }
                }
            }

            if (found) {
                out.println("<h1>Welcome back, " + name + "!</h1>");
            } else {
                out.println("<h1>You are new here!</h1>");
            }

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
        return "Cookie Tracking Servlet";
    }
}
