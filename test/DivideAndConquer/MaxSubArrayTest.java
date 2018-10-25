package DivideAndConquer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayTest {

    private static MaxSubArray m;

    @BeforeAll
    static void setup() {
        m = new MaxSubArray();
    }

    @Test
    void positiveArray() {
        int[] start = {1,2,3,4,5,6};
        assertArrayEquals(start, m.getMaxSubArray(start));
    }

    @Test
    void negativeArray() {
        int[] start = {-5,-4,-3,-2,-1};
        int[] expected = {-1};
        assertArrayEquals(expected, m.getMaxSubArray(start));
    }

    @Test
    void normalArray() {
        int[] start = {-1,4,-2,5,-11,1};
        int[] expected = {4,-2,5};
        assertArrayEquals(expected, m.getMaxSubArray(start));
    }

    @Test
    void smallArray() {
        int[] start = {1};
        int[] expected = {1};
        assertArrayEquals(expected, m.getMaxSubArray(start));
    }

    @Test
    void emptyArray() {
        int[] start = {};
        int[] expected = {};
        assertArrayEquals(expected, m.getMaxSubArray(start));
    }

    @Test
    void nullArray() {
        assertNull(m.getMaxSubArray(null));
    }
}