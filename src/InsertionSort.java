import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author William Pitchford
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
          for(int k = j; k < i; k++){
            swap(values, k, i);
          }//swap for loop
        }//if
      }//inner for loop
    }//outer for loop
  } // sort(T[], Comparator<? super T>)

  public <T> void swap(T[] values, int left, int right) {
    T temp = values[left];
    values[left] = values[right];
    values[right] = temp;
  }//swap(T[], int, int)
} // class InsertionSort
