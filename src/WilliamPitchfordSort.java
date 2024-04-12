/**
 * @author William Pitchford
 * @author ChatGPT
 * Purpose: Trying to implement a really fast sorting method
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WilliamPitchfordSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  WilliamPitchfordSort() {
  } // WilliamPitchfordSort()

  public static Sorter SORTER = new WilliamPitchfordSort();


    public static <T> void bucketSort(T[] array, int numBuckets, Comparator<? super T> comparator) {
        if (array == null || array.length == 0)
            return;

        // Create buckets
        List<T>[] buckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements to buckets
        for (T element : array) {
            int bucketIndex = hash(element, numBuckets);
            buckets[bucketIndex].add(element);
        }

        // Sort individual buckets
        for (List<T> bucket : buckets) {
            Collections.sort(bucket, comparator);
        }

        // Merge buckets back to original array
        int index = 0;
        for (List<T> bucket : buckets) {
            for (T element : bucket) {
                array[index++] = element;
            }
        }
    }

    private static <T> int hash(T element, int numBuckets) {
        // Custom hash function, can be adjusted based on requirements
        return Math.abs(element.hashCode()) % numBuckets;
    }

    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        bucketSort(values, 20, order);
    } // sort(T[], Comparator<? super T>
}
