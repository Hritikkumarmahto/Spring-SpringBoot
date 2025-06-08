import java.sql.*;

class firstJDBC {
  public static void main(String[] args) {
    try {
      // Step 1: Register the driver class
      Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver classclear

      // Step 2: Establish a connection
      String url = "jdbc:mysql://localhost:3306/company"; // Replace "Practice" with your database name
      String userName = "root"; // Replace with your MySQL username
      String passWord = "Hritik@1234"; // Replace with your MySQL password

      Connection con = DriverManager.getConnection(url, userName, passWord);

      // Step 3: Check if the connection is open
      if (con.isClosed()) {
        System.out.println("Connection is still closed");
      } else {
        System.out.println("Connection created successfully...");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
