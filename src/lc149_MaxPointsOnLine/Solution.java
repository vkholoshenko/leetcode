package lc149_MaxPointsOnLine;

import java.util.HashMap;
import java.util.Map;
// 97:02
class Solution {
    static class Ratio {
        public long a;
        public long b;
        public Ratio(long a, long b) {
            this.a = a;
            this.b = b;
        }
        public Ratio mult(int x) {
            return new Ratio(this.a * x, this.b);
        }
        public Ratio add(int val) {
            return new Ratio(this.a + this.b * val, this.b);
        }
        public Ratio add(Ratio val) {
            return new Ratio(this.a * val.b + val.a * this.b, this.b * val.b);
        }

        @Override
        public int hashCode() {
            return (int)(a * b % Integer.MAX_VALUE);
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof Ratio) &&
                    ((Ratio)obj).a * b == ((Ratio)obj).b * a;
        }
    }
    static class Line {
        private Ratio k = null;
        private Ratio b = null;
        private Integer x = null;
        public Line(int[] point1, int[] point2) {
            if (point1[0] == point2[0]) {
                x = point1[0];
            } else {
                int x1 = point1[0], y1 = point1[1], x2 = point2[0], y2 = point2[1];
                k = new Ratio(y1 - y2, x1 - x2);
                b = k.mult(-x1).add(y1);
            }
        }
        public boolean lies(int[] point) {
            if (x != null) {
                return point[0] == x;
            } else {
                return new Ratio(point[1], 1).equals(k.mult(point[0]).add(b));
            }
        }

        @Override
        public int hashCode() {
            if (this.x != null) return x;
            return (this.k.hashCode() * this.b.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Line) {
                Line line = (Line)obj;
                return (k == null && line.k == null || k != null && k.equals(line.k)) &&
                        (b == null && line.b == null || b != null && b.equals(line.b)) &&
                        (x == null && line.x == null || x != null && x.equals(line.x));

            }
            return false;
        }
    }
    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;
        HashMap<Line, Integer> lines = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                if (!lines.containsKey(line)) lines.put(line, lines.size());
            }
        }
        int[] nums = new int[lines.size()];

        for (int[] point : points) {
            for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
                if (entry.getKey().lies(point)) nums[entry.getValue()]++;
            }
        }
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }
}