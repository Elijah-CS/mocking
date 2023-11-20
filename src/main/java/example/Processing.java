package example;

public class Processing {
  public String callExternal(Connection conn) throws Exception {

    String response = actualWork(conn);
    return response;
  }

  protected String actualWork(Connection conn) throws Exception {
    String response = conn.doAction();
    return response;
  }
}