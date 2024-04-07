import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author William Pitchford
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public <T> void merge(T[] vals, int lb, int mid, int ub, Comparator<? super T> comparator) {
    T[] temp = Arrays.copyOfRange(vals, 0, vals.length);
    int mergePos = lb;
    int lo = lb;

    while(lo != mid) {
      int pos = comparator.compare(vals[lb], vals[mid]);

      if(pos < 0) {
        temp[mergePos] = vals[lo];
        lo++;
      } else {
        temp[mergePos] = vals[mid];
        mid++;
      }//if else statement

      for(int i = lb; i < ub; i++) {
        vals[i] = temp[i];
      }//for loop
    }//While loop
    return;
  }

  public <T> void mergesort(T[] values, Comparator<? super T> comparator, int lb, int ub) {
    if((ub-lb) <= 1) {
      return;
    } else {
      merge(values, lb, (lb+(ub-lb)/2), ub, comparator);
      mergesort(values, comparator, lb, (lb+(ub-lb)/2));
      mergesort(values, comparator, (lb+(ub-lb)/2)+1, ub);
    }
  }

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    mergesort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>
} // class MergeSort
