package training.java9collections;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CollectionsMain {

    public static void main(String[] args) {
        List<String> names = List.of("John Doe", "Jack Doe", "Jane Doe");
        //names.add("John Doe"); // UOE
        //names.set(0, "Jane Doe"); // UOE

        List<String> nicks = Arrays.asList("John", "Jack", "Jane");
        //nicks.add("John"); // UOE
        nicks.set(0, "Jane");
        System.out.println(nicks);

        Map<Long, String> employees =
//                Map.of(1L, "John Doe", 2L, "Jane Doe");
                Map.ofEntries(Map.entry(1L, "John Doe"),
                        Map.entry(2L, "Jane Doe")
                        );

        System.out.println(employees);
    }
}
