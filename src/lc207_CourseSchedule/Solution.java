package lc207_CourseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> dependents = new ArrayList<>();
        ArrayList<HashSet<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependents.add(new ArrayList<>());
            dependencies.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int requires = prerequisites[i][1];

            dependents.get(requires).add(course);
            dependencies.get(course).add(requires);
        }

        Deque<Integer> ready = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (dependencies.get(i).isEmpty()) {
                ready.add(i);
            }
        }
        while (!ready.isEmpty()) {
            Integer course = ready.poll();
            for (Integer dependent : dependents.get(course)) {
                dependencies.get(dependent).remove(course);
                if (dependencies.get(dependent).isEmpty()) {
                    ready.add(dependent);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dependencies.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}