import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Your Name Here
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    for(int i = 0; i < values.length; i++) {
      for(int j = 0; j < i; j++) {
        int pos = order.compare(values[i], values[j]);
        if(pos < 0) {
          T temp = values[j];
          values[j] = values[i];
          for(int k = j; k < i; k++){
            values[k+1] = values[k];
            values[k] = temp;

          }
        }
      }//inner for loop
    }//outer for loop
  } // sort(T[], Comparator<? super T>
} // class InsertionSort
