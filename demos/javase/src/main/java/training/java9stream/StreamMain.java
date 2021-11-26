package training.java9stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 10)
//                .takeWhile(i -> i < 5)
                .dropWhile(i -> i < 5)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        System.out.println(numbers);

        String name = "John Doe";
        List<String> names = Stream.ofNullable(name).collect(Collectors.toList());
        System.out.println(names);

        Stream.iterate(0, i -> i < 10, i -> i + 1)
                .forEach(System.out::println);

        // Optional.ofNullable(name).stream();

        List<Optional<Integer>> n =
                List.of(
                        Optional.of(0),
                        Optional.of(1),
                        Optional.empty(),
                        Optional.of(2),
                        Optional.empty()
                );

        n.stream()
                .flatMap(Optional::stream)
                .forEach(System.out::println);

        String name1 = "John";
        String s = Optional.ofNullable(name1)
                .or(() -> Optional.of("anonymous")).get();
        System.out.println(s);

        String name2 = null;
        Optional.ofNullable(name2).ifPresentOrElse(System.out::println, () -> System.out.println("empty"));
    }
}
