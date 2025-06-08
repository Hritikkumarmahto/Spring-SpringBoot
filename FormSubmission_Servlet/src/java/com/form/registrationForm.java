package com.form;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class registrationForm extends HttpServlet {

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display heading
        out.print("<h1>Your details are here</h1>");

        // Retrieve form data
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String email = request.getParameter("user_email");
        String gender = request.getParameter("userGender");
        String course = request.getParameter("user_course");
        String condition = request.getParameter("condition");

        // Check if the terms and conditions are accepted
        if (condition != null && condition.equals("checked")) {
            out.println("<h2>Name: " + name + "</h2>");
            out.println("<h2>Password: " + password + "</h2>");
            out.println("<h2>Email: " + email + "</h2>");
            out.println("<h2>Gender: " + gender + "</h2>");
            out.println("<h2>Course: " + course + "</h2>");
            out.println("<p>You agreed to the terms and conditions.</p>");
            
            
            
            
            
            // here we are using foward method
            RequestDispatcher rd=request.getRequestDispatcher("success");
            
            // if we want thr form again so we have to include it 
            rd.include(request,response);
            
        } else {
            out.println("<p>Please accept the terms and conditions.</p>");
            
            // we wnat the index.html forom here also so we have to use request dispacther 
            // create the object of request dispatcher
            RequestDispatcher rd=request.getRequestDispatcher("index.html");
            
            // if we want thr form again so we have to include it 
            rd.include(request,response);
            
        }
    }
}
