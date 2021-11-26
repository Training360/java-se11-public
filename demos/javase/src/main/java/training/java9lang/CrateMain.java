package training.java9lang;

public class CrateMain {

    public static void main(String[] args) {
        Crate<String> crate = new Crate<>() {
            @Override
            public void put(String content) {

            }

            @Override
            public void empty() {

            }
        };
    }
}
