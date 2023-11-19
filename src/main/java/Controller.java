public class Controller {

  public String callExternalTool() {

    System.out.println("In Controller");

    return helper();
  }

  private String helper() {
    System.out.println("Calling External Tool");

    ExternalTool tool = new ExternalTool();

    return tool.doAction();
  }
}
