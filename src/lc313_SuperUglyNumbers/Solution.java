package lc313_SuperUglyNumbers;

import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ns = new int[1000000];
        int[] idxs = new int[1000];
        PriorityQueue<Integer> candidates = new PriorityQueue<>();
        HashMap<Integer, ArrayList<Integer>> pointers = new HashMap<>();
        ArrayList<Integer> todo;
        int val, next;
        ns[1] = 1;
        pointers.put(1, new ArrayList<>());
        for (int i = 0; i < primes.length; i++) {
            idxs[i] = 0;
            pointers.get(1).add(i);
        }
        candidates.add(1);

        for (int last=1; last <= n; last++) {
            next = candidates.poll();
            ns[last] = next;
            todo = pointers.get(next);
            if (todo != null) {
                for (int i : todo) {
                    idxs[i]++;
                    val = primes[i] * ns[idxs[i]];
                    ArrayList<Integer> item = pointers.get(val);
                    if (item == null) {
                        candidates.add(val);
                        item = new ArrayList<>();
                    }
                    item.add(i);
                    pointers.put(val, item);
                }
            }
            pointers.remove(next);
        }
        return ns[n];
    }
    public int nthSuperUglyNumber_better(int n, int[] primes) {
        int[] ns = new int[1000000];
        int[] idxs = new int[1000];
        for (int i = 0; i < primes.length; i++) {
            idxs[i] = 1;
        }
        ns[1] = 1;
        for (int last=2; last <= n; last++) {
            int next = primes[0] * ns[idxs[0]];
            for (int j = 1; j < primes.length; j++) {
                next = Math.min(next, primes[j] * ns[idxs[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (next == primes[j] * ns[idxs[j]]) {
                    idxs[j]++;
                }
            }

            ns[last] = next;
        }
        return ns[n];

    }

    public int nthSuperUglyNumber0(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        int x = 1, c = -1;
        long next;
        while (x < n) {
            c = queue.poll();
            for (int i : primes) {
                next = (long)i * (long)c;
                if (next < Integer.MAX_VALUE) queue.add(i * c);
            }
            x++;
            while (c == queue.peek()) {
                c = queue.poll();
            }
        }
        return queue.peek();
    }
    public int nthSuperUglyNumber_takoe(int n, int[] primes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(1);
        set.add(1);
        int x = 1, c = -1, inext;
        long lnext;
        while (x < n) {
            c = queue.poll();
            for (int i : primes) {
                lnext = (long)i * (long)c;
                if (lnext < Integer.MAX_VALUE) {
                    inext = i * c;
                    if (!set.contains(inext)) {
                        set.add(inext);
                        queue.add(inext);
                    }
                }
            }
            x++;
        }
        return queue.peek();
    }
}