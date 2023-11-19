
import static org.junit.Assert.*;
import org.junit.Test;

public class TestMain {

  @Test
  public void testMain() {
    Other other = new Other();

    other.doSomething();

    System.out.println("hello");
    assertTrue(false);
  }
}