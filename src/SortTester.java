import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Comparator <Integer> intComp = (x,y) -> x == y ? 0 : x < y ? -1 : 1;
  Comparator <String> strComp = (str1,str2) -> str1.compareTo(str2); 

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void emptyListTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, strComp);
    assertArrayEquals(original, expected);
  } //empty list test

  @Test
  public void reverseOrderedIntTest() {
    Integer[] original = { 5, 4, 3, 2, 1 };
    Integer[] expected = { 1, 2, 3, 4, 5 };
    sorter.sort(original, intComp);
    assertArrayEquals(original, expected);
  }

  @Test
  public void orderedIntTest() {
    Integer[] original = { 1, 2, 3, 4, 5 };
    Integer[] expected = { 1, 2, 3, 4, 5 };
    sorter.sort(original, intComp);
    assertArrayEquals(original, expected);
  }

  @Test
  public void randOrderedIntTest() {
    Integer[] original = { 2, 4, 3, 5, 1 };
    Integer[] expected = { 1, 2, 3, 4, 5 };
    sorter.sort(original, intComp);
    assertArrayEquals(original, expected);
  }

  @Test
  public void randOrderedStringTest() {
    String[] original = { "delta", "alpha", "foxtrot", "bravo", "charlie" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

} // class SortTester
