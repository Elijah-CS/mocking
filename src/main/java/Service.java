
public class Service {
  public String doService() {
    System.out.println("doing service");

    Controller controller = new Controller();

    System.out.println("calling controller function");
    String action = controller.callExternalTool();

    System.out.println(action);

    return action;
  }
}