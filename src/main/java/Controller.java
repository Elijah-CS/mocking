public class Controller {

  public String callExternalTool() {

    System.out.println("Calling External Tool");

    ExternalTool tool = new ExternalTool();

    return tool.doAction();
  }
}
