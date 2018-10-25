package DivideAndConquer;

import util.Triple;
import java.util.Arrays;

public class MaxSubArray {

    /**
     * Setup method for the maxSubArray() method.
     * @param a is the array to be analyzed
     * @return returns the array with the maximum sum. If the input is null, the method returns null
     */
    public int[] getMaxSubArray(int[] a) {
        if (a == null) return null;
        else if (a.length == 0 || a.length == 1) return a;
        Triple<Integer, Integer, Integer> t = maxSubArray(a, 0, a.length - 1);
        return Arrays.copyOfRange(a, t.x, t.y + 1);
    }

    /**
     * This method finds the bounds and sum of the maximum sub array. Assumes that a will never be null.
     * @param a the array to be analyzed
     * @param low the lower bound of the current sub array (inclusive)
     * @param high the upper bound of the current sub array (inclusive)
     * @return Returns the triple (lower bound, upper bound, sum) of the maximum sub array.
     */
    private Triple<Integer,Integer,Integer> maxSubArray(int[] a, int low, int high) {
        if (low == high) return new Triple<>(low, high, a[low]);

        int mid = (low + high) / 2;

        Triple max = maxSubArray(a, low, mid);
        max = maxTriple(max, maxSubArray(a, mid + 1, high));
        max = maxTriple(max, maxAcrossMid(a, low, mid, high));

        return max;
    }

    /**
     * This method finds the maximum sub array across the mid-line
     * @param a the array to be analyzed
     * @param low the lower bound of the current sub array (inclusive)
     * @param mid the middle of the current sub array ((low + high) / 2)
     * @param high the upper bound of the current sub array (inclusive)
     * @return returns the triple (lower bound, upper bound, sum) of the maximum sub array over the middle line.
     */
    private Triple<Integer,Integer,Integer> maxAcrossMid(int[] a, int low, int mid, int high) {
        int leftBound = mid;
        int rightBound = mid + 1;
        int leftSum = a[mid];
        int rightSum = a[mid + 1];

        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftBound = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightBound = i;
            }
        }
        return new Triple<>(leftBound, rightBound, leftSum + rightSum);
    }

    /**
     * This method compares two triples and returns the one with the max sum (the third element in each triple)
     * @param t1 The first triple
     * @param t2 The second triple
     * @return the maximum triple. If there is a tie, return the first triple. If either one is null, return null
     */
    private Triple<Integer,Integer,Integer> maxTriple(Triple<Integer,Integer,Integer> t1,
                                                      Triple<Integer,Integer,Integer> t2) {
        if (t1 == null || t2 == null) return null;
        if (t1.z >= t2.z) return t1;
        else return t2;
    }
}
