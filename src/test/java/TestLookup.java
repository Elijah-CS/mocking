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
    int numNull1 = testNull(numLoops);
    long after1 = Instant.now().toEpochMilli();

    System.out.println(after1 - start1);
    System.out.println("num null1: " + numNull1);

    long start2 = Instant.now().toEpochMilli();
    int numNull2 = testOptional(numLoops);
    long after2 = Instant.now().toEpochMilli();

    System.out.println(after2 - start2);
    System.out.println("num null2: " + numNull2);

  }

  public int testNull(int numLoops) {

    int numNull = 0;

    for (int i = 0; i < numLoops; i++) {
      Integer num = getNum();

      if (num != null) {
        num.byteValue();
        numNull++;
        continue;
      } else {
        continue;
      }

    }

    return numNull;

  }

  public int testOptional(int numLoops) {

    int numNull = 0;

    for (int i = 0; i < numLoops; i++) {
      Optional<Integer> num = getOptionalNum();

      if (num.isPresent()) {
        Integer a = num.get();
        a.byteValue();
        numNull++;
        continue;
      } else {
        continue;
      }

    }

    return numNull;

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