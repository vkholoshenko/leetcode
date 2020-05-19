package lc264;

class Solution {
    public int nthUglyNumber(int n) {
        int[] ns = new int[1695];
        int i2 = 1, i3 = 1, i5 = 1;
        int ni2, ni3, ni5;
        ns[1] = 1;
        for (int last=2; last <= n; last++) {
            ni2 = ns[i2] * 2;
            ni3 = ns[i3] * 3;
            ni5 = ns[i5] * 5;
            ns[last] = Math.min(ni2, Math.min(ni3, ni5));
            if (ni2 == ns[last]) i2++;
            if (ni3 == ns[last]) i3++;
            if (ni5 == ns[last]) i5++;
        }
        return ns[n];
    }
    /*public int nthUglyNumber2(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(1);
        set.add(1);
        int x = 1, c = -1, inext;
        int[] primes = new int[3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;

        long lnext;
        while (x < n) {
            c = queue.poll();
            for (int i : primes) {
                lnext = (long)i * (long)c;
                if (lnext > Integer.MAX_VALUE) {
                    break;
                }
                inext = i * c;
                if (!set.contains(inext)) {
                    set.add(inext);
                    queue.add(inext);
                }
            }
            x++;
        }
        return queue.peek();
    }*/
}