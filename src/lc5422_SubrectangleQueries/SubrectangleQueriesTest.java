package lc5422_SubrectangleQueries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubrectangleQueriesTest {
    @Test
    public void test1()
    {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(
                new int[][]{
                        new int[]{1,2,1},
                        new int[]{4,3,4},
                        new int[]{3,2,1},
                        new int[]{1,1,1}});
        assertEquals(1, subrectangleQueries.getValue(0, 2)); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
// After this update the rectangle looks like:
// 5 5 5
// 5 5 5
// 5 5 5
// 5 5 5
        assertEquals(5, subrectangleQueries.getValue(0, 2)); // return 5
        assertEquals(5, subrectangleQueries.getValue(3, 1)); // return 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
// After this update the rectangle looks like:
// 5   5   5
// 5   5   5
// 5   5   5
// 10  10  10
        assertEquals(10, subrectangleQueries.getValue(3, 1)); // return 10
        assertEquals(5, subrectangleQueries.getValue(0, 2)); // return 5
    }
}