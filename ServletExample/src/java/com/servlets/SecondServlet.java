package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
public class SecondServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("This is servlet using GenericServlet");

        res.setContentType("text/html");
        PrintWriter obj = res.getWriter();
        obj.println("<h1>This is the second servlet using GenericServlet class</h1>");
    }
}
