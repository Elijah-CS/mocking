
public class Service {
  public String doService() {
    System.out.println("doing service");

    // ExternalTool tool = new ExternalTool();
    // String action = tool.doAction();

    Controller controller = new Controller();
    String action = controller.callExternalTool();

    System.out.println(action);

    return action;
  }
}