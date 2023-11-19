
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Service.class)
public class TestMain {

  @Test
  public void testMain() throws Exception {

    System.out.println("hello");

    Service service = new Service();
    String action = service.doService();

    assertEquals("doing external act", action);

    mockExternalTool();

    service = new Service();
    action = service.doService();

    assertEquals("mock action", action);
  }

  public void mockExternalTool() throws Exception {
    ExternalTool tool = PowerMockito.mock(ExternalTool.class);

    PowerMockito.when(tool.doAction()).thenReturn("mock action");
    PowerMockito.whenNew(ExternalTool.class).withNoArguments().thenReturn(tool);
  }

}