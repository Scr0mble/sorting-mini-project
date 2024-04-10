/**
 * @author William Pitchford
 * @author ChatGPT
 * Purpose: Trying to implement a really fast sorting method
 */
import java.util.ArrayList;
import java.util.Collections;

public class WilliamPitchfordSort {

  public static <T extends Comparable<T>> void bucketSort(T[] arr) {
    if (arr == null || arr.length == 0) {
        return;
    }

    int n = arr.length;
    @SuppressWarnings("unchecked")
    ArrayList<T>[] buckets = new ArrayList[n];

    // Create empty buckets
    for (int i = 0; i < n; i++) {
        buckets[i] = new ArrayList<>();
    }

    // Add elements into buckets
    for (int i = 0; i < n; i++) {
        int bucketIndex = (int) (n * arr[i].compareTo(arr[0]));
        buckets[bucketIndex].add(arr[i]);
    }

    // Sort individual buckets
    for (int i = 0; i < n; i++) {
        Collections.sort(buckets[i]);
    }

    // Concatenate all buckets into arr[]
    int index = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < buckets[i].size(); j++) {
            arr[index++] = buckets[i].get(j);
        }
    }
}
}
