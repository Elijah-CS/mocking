import java.util.Optional;

import org.junit.Test;

import java.util.Random;
import java.time.Instant;
import java.math.BigInteger;

public class TestLookup {

  @Test
  public void testMain() throws Exception {

    int numLoops = 100000000;

    long start1 = Instant.now().toEpochMilli();
    testNull(numLoops);
    long after1 = Instant.now().toEpochMilli();

    System.out.println(after1 - start1);

    long start2 = Instant.now().toEpochMilli();
    testOptional(numLoops);
    long after2 = Instant.now().toEpochMilli();

    System.out.println(after2 - start2);

  }

  public void testNull(int numLoops) {

    for (int i = 0; i < numLoops; i++) {
      Integer num = getNum();

      if (num != null) {
        continue;
      } else {
        continue;
      }

    }

  }

  public void testOptional(int numLoops) {

    for (int i = 0; i < numLoops; i++) {
      Optional<Integer> num = getOptionalNum();

      if (num.isPresent()) {
        Integer a = num.get();
        continue;
      } else {
        continue;
      }

    }

  }

  public Integer getNum() {
    Random r = new Random();
    int low = 1;
    int high = 100;

    Integer result = r.nextInt(high - low) + low;

    if (result % 3 == 0) {
      return null;
    }

    return result;
  }

  public Optional<Integer> getOptionalNum() {
    Random r = new Random();
    int low = 1;
    int high = 100;

    Integer result = r.nextInt(high - low) + low;

    if (result % 3 == 0) {
      return Optional.empty();
    }

    return Optional.of(result);
  }

}