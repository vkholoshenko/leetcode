package lc756_PyramidTransitionMatrix;

import java.util.HashSet;
import java.util.List;

class Solution {
    class Level {
        HashSet<Character>[] items;
        int size;
        public Level(int size) {
            this.size = size;
            items = new HashSet[size];
            for (int i=0; i< size;i++) {
                items[i] = new HashSet<Character>();
            }
        }
    }
    class TransitionMap {
        HashSet<Character>[][] data;
        TransitionMap(List<String> allowed) {
            data = new HashSet[7][7];
            for (String s : allowed) {
                add(s);
            }
        }
        HashSet<Character> get(Character c1, Character c2) {
            HashSet<Character> result = data[(int)c1 - (int)'A'][(int)c2 - (int)'A'];
            if (result == null) {
                return new HashSet<Character>();
            }
            return result;
        }
        void add(String s) {
            int i1 =(int)s.charAt(0) - (int)'A';
            int i2 =(int)s.charAt(1) - (int)'A';
            if (data[i1][i2] == null)  {
                data[i1][i2] = new HashSet<Character>();
            }
            data[i1][i2].add(s.charAt(2));
        }
    }
    public Level nextLevel(Level input, TransitionMap transitionMap) {
        Level result = new Level(input.size - 1);
        for (int i = 0; i < input.size - 1; i++) {
            for (Character c1 : input.items[i]) {
                for (Character c2 : input.items[i+1]) {
                    for (Character r : transitionMap.get(c1, c2)) {
                        result.items[i].add(r);
                    }
                }
            }
            if (result.items[i].isEmpty()) {
                return null;
            }
        }
        return result;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Level currentLevel = new Level(bottom.length());
        for (int i=0; i<bottom.length(); i++) {
            currentLevel.items[i].add(bottom.charAt(i));
        }
        TransitionMap transitionMap = new TransitionMap(allowed);

        while (currentLevel != null && currentLevel.size > 1) {
            currentLevel = nextLevel(currentLevel, transitionMap);
        }
        return currentLevel != null;
    }
}