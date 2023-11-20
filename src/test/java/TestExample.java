
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;

import example.Adapter;
import example.DBService;
import example.DBTableType;
import example.Processing;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Adapter.class })
public class TestExample {

  @Test
  public void testMain() throws Exception {

    DBService service = mockService();

    mockPrivate();

    Adapter adapter = new Adapter();
    String action = adapter.buildThing(service);

    assertEquals("mocked response", action);
  }

  private void mockPrivate() throws Exception {
    Processing processing = PowerMockito.spy(new Processing());

    PowerMockito.doReturn("mocked response")
        .when(processing, PowerMockito.method(Processing.class, "getTableData", Connection.class, DBTableType.class))
        .withArguments(any(Connection.class), any(DBTableType.class));

    PowerMockito.whenNew(Processing.class).withNoArguments().thenReturn(processing);
  }

  private DBService mockService() throws Exception {
    Connection conn = PowerMockito.mock(Connection.class);
    DBService service = PowerMockito.mock(DBService.class);

    PowerMockito.when(service.getConnection()).thenReturn(conn);

    return service;
  }

}