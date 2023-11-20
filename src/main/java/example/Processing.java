package example;

import java.sql.Connection;

public class Processing {
  public String buildThing(Connection conn) throws Exception {

    System.out.println("In processor buildThing");

    String response = getTableData(conn, DBTableType.TABLE1);
    return response;
  }

  protected String getTableData(Connection conn, DBTableType tableType) throws Exception {

    System.out.println("In real method");

    conn.createStatement().executeQuery("dumb");
    return "Did it";
  }
}