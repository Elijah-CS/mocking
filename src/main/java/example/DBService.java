package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
  public Connection getConnection() throws SQLException {
    System.out.println("Getting a connection");

    return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring");
  }
}