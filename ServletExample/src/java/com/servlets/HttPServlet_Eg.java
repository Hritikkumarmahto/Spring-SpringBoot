
package com.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HttPServlet_Eg extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        System.out.println("This is servlet created by httpServlet");
        
        res.setContentType("text/html");
        
        PrintWriter out=res.getWriter();
        out.println("<h1>this is a class created by HttpServlet</h1>");
        
    }
}
