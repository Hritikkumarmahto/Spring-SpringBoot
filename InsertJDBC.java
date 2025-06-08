import java.sql.*;

public class InsertJDBC {

  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");( )

      String url = "jdbc:mysql://localhost:3306/record";

      String userName = "root";
      String password = "Hritik@1234";

      Connection con = DriverManager.getConnection(url, userName, password);

      // create a query
      String q = "create table table1(id int(20) primary key auto_increment,name varchar(200) not null, city varchar(400))";

      Statement stmt = con.createStatement();

      stmt.executeUpdate(q);

      System.out.println("Table created");
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
