package com.form;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SucessServlet extends HttpServlet {

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display heading
        out.print("<h1>You registered sucessfully</h1>");

            
        }
    }
