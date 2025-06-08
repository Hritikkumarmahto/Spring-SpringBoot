package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.*;

// Servlet is an interface, that's why we implement it
public class first_servlet implements Servlet {

    // Life cycle methods
    ServletConfig conf;

    @Override
    public void init(ServletConfig conf) {
        this.conf = conf;
        System.out.println("Creating object");
        
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servicing......");
        
        // set the content type of the object 
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>This is a lie by servlet</h1>");
        out.println("<h1>Today's date is " + new Date().toString() + "</h1>");
        
    }

    @Override
    public void destroy() {
        System.out.println("This is destroying");
    }

    // Non-life cycle methods
    @Override
    public ServletConfig getServletConfig() {
        return this.conf;
    }

    @Override
    public String getServletInfo() {
        return "This servlet was created by me";
    }
}
