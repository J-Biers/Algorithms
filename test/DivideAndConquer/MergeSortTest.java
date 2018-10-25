package DivideAndConquer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    static MergeSort m;

    @BeforeAll
    static void setup() {
        m = new MergeSort();
    }

    @Test
    void emptyArray() {
        int[] start = {};
        int[] expected = {};
        callSortAndCompare(start, expected);
    }

    private void callSortAndCompare(int[] start, int[] expected) {
        m.sort(start);
        assertArrayEquals(expected, start);
    }

    @Test
    void descendingArray() {
        int[] start = {5,4,3,2,1};
        int[] expected = {1,2,3,4,5};
        callSortAndCompare(start, expected);
    }

    @Test
    void ascendingArray() {
        int[] start = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        callSortAndCompare(start, expected);
    }

    @Test
    void negativeArray() {
        int[] start = {-1,-2,-3,-4,-5};
        int[] expected = {-5,-4,-3,-2,-1};
        callSortAndCompare(start, expected);
    }
}