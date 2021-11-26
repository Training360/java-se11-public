package training.java9lang;

import java.util.HashMap;
import java.util.Map;

public class PrintableMain {

    public static void main(String[] args) {
        Printable aPrintable = Printable.of("book,Java 9");

        Map<String, String> properties = new HashMap<>();
        properties.put("type", "book");
        properties.put("title", "Java 10");

        Printable java10 = Printable.of(properties);
    }
}
