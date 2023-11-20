package example;

import java.sql.Connection;

public class Adapter implements DataAdapter {
  public String buildThing(DBService service) throws Exception {
    System.out.println("In Service");

    try (Connection conn = service.getConnection()) {

      System.out.println("In try/catch");

      Processing proc = new Processing();
      String result = proc.buildThing(conn);

      return result;
    }
  }
}