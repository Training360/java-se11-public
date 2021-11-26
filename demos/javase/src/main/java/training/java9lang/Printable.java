package training.java9lang;

import java.util.Map;

public interface Printable {

    static Printable of(String csv) {
        String[] parts = csv.split(",");
        String type = parts[0];
        String title = parts[1];

        return create(type, title);
    }

    static Printable of(Map<String, String> properties) {
        String type = properties.get("type");
        String title = properties.get("title");;

        return create(type, title);
    }

    private static Printable create(String type, String title) {
        if ("book".equals(type)) {
            // Példányosítás
            return null;
        }
        else {
            return null;
        }
    }

}
