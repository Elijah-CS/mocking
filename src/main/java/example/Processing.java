package example;

import java.sql.Connection;

public class Processing {
  public String buildThing(Connection conn) throws Exception {

    System.out.println("In processor buildThing");

    String response = actualWork(conn);
    return response;
  }

  protected String actualWork(Connection conn) throws Exception {

    System.out.println("In real method");

    conn.createStatement().executeQuery("dumb");
    return "Did it";
  }
}