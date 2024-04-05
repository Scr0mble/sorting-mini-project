import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public <T> void swap(T[] values, int left, int right) {
    T temp = values[left];
    values[left] = values[right];
    values[right] = temp;
  } //swap(T[], int, int)

  public <T> void partition(T[] values, Comparator<? super T> order, int lb, int ub) {
    swap(values, lb, (lb + (ub-lb) / 2));

    int small = lb+1;
    int large = ub;

    while(small != large) {
      int pos = order.compare(values[small], values[lb]);

      if(pos < 0){
        small++;
      } else if(pos > 0) {
        swap(values, large-1, small);
        large--;
      }
    }
  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // STUB
  } // sort(T[], Comparator<? super T>
} // class Quicksort
