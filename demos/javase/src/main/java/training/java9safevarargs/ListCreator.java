package training.java9safevarargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCreator {

    public static void main(String[] args) {
        // List<String>[] l = new List[3];

        List<String>[] l = (List<String>[]) new List<?>[3];
        Object[] objectArray = l;
        objectArray[0] = Arrays.asList(1, 2);
        System.out.println(l[0].get(0));

        asList("a", "b", "c");
        // asList(new Object[]{"a", "b", "b"});
    }

    @SafeVarargs
    public static <T> List<T> asList(T... elements) {
        List<T> result = new ArrayList<>();
        for (T element: elements) {
            result.add(element);
        }
        return result;
    }


}
