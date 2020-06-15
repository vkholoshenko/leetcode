package lc119_PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return null;
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        List<Integer> prevRow = null;

        for (int i = 1; i <= rowIndex; i++) {
            prevRow = newRow;
            newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < i; j++) {
                newRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            newRow.add(1);
        }
        return newRow;
    }
}