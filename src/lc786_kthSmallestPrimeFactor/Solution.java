package lc786_kthSmallestPrimeFactor;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Fraction {
        int divident;
        int divisor;
        public Fraction(int p, int q) {
            if (p < q) {
                divident = p;
                divisor = q;
            } else {
                divident = q;
                divisor = p;
            }
        }
    }
    static class FractionComparator implements Comparator<Fraction> {
        public boolean equals(Fraction f1, Fraction f2) {
            return f1.divident == f2.divident && f1.divisor == f2.divisor;
        }
        public int compare(Fraction f1, Fraction f2) {
            return -FractionComparator.compareStatic(f1, f2);
        }
        public static int compareStatic(Fraction f1, Fraction f2) {
            return f1.divident * f2.divisor - f2.divident * f1.divisor;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Fraction> heap = new PriorityQueue<>(new FractionComparator());

        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                Fraction next = new Fraction(A[i], A[j]);
                if (heap.size() < K) {
                    heap.add(next);
                } else if (FractionComparator.compareStatic(next, heap.peek()) < 0) {
                    heap.poll();
                    heap.add(next);
                }
            }
        }
        int[] result = new int[2];
        result[0] = heap.peek().divident;
        result[1] = heap.peek().divisor;
        return result;
    }
}