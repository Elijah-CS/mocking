package example;

public class Adapter {
  public String buildThing(DBService service) throws Exception {

    try (Connection conn = service.getConnection()) {

      Processing proc = new Processing();
      String result = proc.callExternal(conn);

      return result;
    }
  }
}