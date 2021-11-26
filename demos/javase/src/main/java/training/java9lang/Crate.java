package training.java9lang;

public interface Crate<T> {

    void put(T content);

    void empty();
}
