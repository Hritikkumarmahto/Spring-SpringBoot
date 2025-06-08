import java.sql.*;
import java.io.*;

public class userINput {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/record";
    String userName = "root";
    String password = "Hritik@1234";
    String query = "insert into table1(name,city) values(?,?)"; // this values(?,?) is called dynamic query or parameter
                                                                // query

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      try (Connection con = DriverManager.getConnection(url, userName, password);
          PreparedStatement psmt = con.prepareStatement(query)) { // PreparedStatement is an interface and
                                                                  // prepareStatement is a method

        BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));

        System.out.println("enter name");
        String name = br.readLine();
        System.out.println("enter city");
        String city = br.readLine();

        // inserting values to the table and id values are coming for any input we have
        // to pass other
        psmt.setString(1, name); // passing the perameter directly
        psmt.setString(2, city);

        psmt.executeUpdate();

        System.out.println("inserted..");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
};
