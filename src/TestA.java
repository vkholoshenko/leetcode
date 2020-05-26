import java.util.HashSet;

public class TestA {
    private Integer a = null;

    public TestA(Integer a) {
        HashSet<Integer>[] dependent = new HashSet[3];

        dependent[0].add(1);

    }
}
