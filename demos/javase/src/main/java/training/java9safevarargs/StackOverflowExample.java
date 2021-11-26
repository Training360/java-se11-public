package training.java9safevarargs;

public class StackOverflowExample {

    static <T> T[] asArray(T... args) {
        return args;
    }

    static <T> T[] arrayOfTwo(T a, T b) {
        return asArray(a, b); // new Object[]{a, b}
    }

    public static void main(String[] args) {
        String[] bar = arrayOfTwo("hi", "mom"); // 2
    }

}
