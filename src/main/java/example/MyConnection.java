package example;

public class MyConnection implements AutoCloseable {

  public MyConnection() throws Exception {
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