import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTestA {
    @Test
    void test() {
        char[][] map = new char[][]{
                {},
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};

        System.out.println(map);
    }
}