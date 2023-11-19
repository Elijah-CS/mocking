
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

    doThing();

    assertTrue(true);
  }

  public void doThing() throws Exception {
    ExternalTool tool = PowerMockito.mock(ExternalTool.class);

    PowerMockito.when(tool.doAction()).thenReturn("mock action");
    PowerMockito.whenNew(ExternalTool.class).withNoArguments().thenReturn(tool);

    Service service = new Service();
    service.doService();
  }

}