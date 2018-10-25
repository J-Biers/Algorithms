package DivideAndConquer;

import java.util.Arrays;

public class MergeSort {

    /**
     * This method is a helper that kicks off the merge sort algorithm.
     * @param a is the array to be sorted.
     */
    public void sort(int[] a) {
        if (a == null) return;
        sort(a, 0, a.length - 1);
    }

    /**
     * recursively splits the array in half then combines them.
     * @param a the array to be worked on
     * @param low the lower bound (inclusive)
     * @param high the upper bound (inclusive)
     */
    private void sort(int[] a, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;

        sort(a, low, mid);
        sort(a, mid+1, high);
        merge(a, low, mid, high);

    }

    /**
     * Combines the two split halves of the array separated by the 'mid' threshold.
     * @param a the array being worked on
     * @param low the lower bound (inclusive)
     * @param mid the floor of the average value between low and high ( (low + high) / 2)
     * @param high the upper bound (inclusive)
     */
    private void merge(int[] a, int low, int mid, int high) {
        //We need to add 1 to both the upper bounds in order to make them exclusive
        int[] left = Arrays.copyOfRange(a, low, mid + 1);
        int[] right = Arrays.copyOfRange(a, mid + 1, high + 1);

        int i = 0, j = 0, index = low;
        while(i < left.length || j < right.length) {
            if (i == left.length) {
                a[index] = right[j];
                j++;
            }
            else if (j == right.length) {
                a[index] = left[i];
                i++;
            }
            else {
                if (left[i] <= right[j]) {
                    a[index] = left[i];
                    i++;
                }
                else {
                    a[index] = right[j];
                    j++;
                }
            }
            index++;
        }
    }
}
