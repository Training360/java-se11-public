package training.java9lang;

public interface Document {

    String getTitle();

    default String getBody() {
        return "[no body]";
    }

    default String toStringRepresentation() {
        return
                annotate("title", getTitle()) + ", " +
                        annotate("body", getBody());
    }

    private String annotate(String fieldName, String content) {
        return String.format("%s: %s", fieldName, content);
    }
}
