package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // Getting all incoming data from the page
            String name = request.getParameter("user_name");
            String email = request.getParameter("user_email");
            String password = request.getParameter("user_password");
            Part part = request.getPart("image"); // Retrieve the file part from the request
            String partName = part.getSubmittedFileName(); // Extract the original file name
            out.println(partName); // Print the file name to the response (for debugging or display)

            // Connecting to the database
            try {
                Thread.sleep(3000);
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/RegistrationForm";
                String userName = "root";
                String passWord = "Hritik@1234";

                Connection con = DriverManager.getConnection(url, userName, passWord);

                String q = "INSERT INTO user(name, email, password) VALUES (?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(q);

                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, password);

                pst.executeUpdate(); // Use executeUpdate for DML statements like INSERT
                out.println("done");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("Error occurred: " + e.getMessage());
            }

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
        return "Short description";
    }
}
