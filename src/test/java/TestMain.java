
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Service.class, Controller.class })
public class TestMain {

  @Test
  public void testMain() throws Exception {

    Service service = new Service();
    String action = service.doService();

    assertEquals("doing external act", action);

    System.out.println("----------------");

    mockPrivate();

    service = new Service();
    action = service.doService();

    assertEquals("mock action", action);
  }

  public void mockPrivate() throws Exception {
    Controller controller = PowerMockito.spy(new Controller());

    PowerMockito.doReturn("mock action")
        .when(controller, PowerMockito.method(Controller.class, "helper"))
        .withNoArguments();

    PowerMockito.whenNew(Controller.class).withNoArguments().thenReturn(controller);
  }

}