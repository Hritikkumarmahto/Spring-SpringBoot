import java.sql.*;

public class PreparedStatments {

  public static void main(String[] args) {
    try {

      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/record";

      String userName = "root";
      String password = "Hritik@1234";

      Connection con = DriverManager.getConnection(url, userName, password);



      String q= "insert into table1(name,city) values(?,?)"; // this vales(?,?) is called dynamic query or perametre query 

      // create the PreparedStatment object
       
      PreparedStatement psmt=con.prepareStatement(q); //PreparedStatment is a interface and prepareStatment is and interface 
      


      // inserting values to the table and id values are coming for any input we have to pass other 

      psmt.setString(1,"Hritik"); // here we used set string because the name is of string type
      psmt.setString(2,"kishanganj");

      psmt.executeUpdate();

      System.out.println("inserted..");
      

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}