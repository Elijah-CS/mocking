
public class Service {
  public String doService() {
    System.out.println("doing service");

    ExternalTool tool = new ExternalTool();

    String action = tool.doAction();

    System.out.println(action);

    return action;
  }
}