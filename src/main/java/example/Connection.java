package example;

public class Connection implements AutoCloseable {

  public Connection() throws Exception {
    // throw new Exception("Bad Connection");
  }

  public String doAction() throws Exception {
    External ext = new External();

    throw new Exception("Bad Connection");

    // return ext.doAction();
  }

  public void close() throws Exception {

  }

}