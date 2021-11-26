package training.java9safevarargs;

import java.util.Arrays;
import java.util.List;

public class JdkExample {

    static void m(List<String>... stringLists) {
        Object[] array = stringLists; // 1
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

}
