package training.java9reactive;

import io.reactivex.rxjava3.core.Flowable;
import reactor.core.publisher.Flux;

import java.util.List;

public class ReactiveMain {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John Doe", 20),
                new Employee("Jack Doe", 25),
                new Employee("Jane Doe", 30)
        );

        Flux.fromIterable(employees)
                .filter(employee -> employee.getAge() >= 25)
                .map(Employee::getName)
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        Flowable.fromIterable(employees)
                .filter(employee -> employee.getAge() >= 25)
                .map(Employee::getName)
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        Flux.from(Flowable.fromIterable(employees)
                .filter(e -> e.getAge() >= 25)
                .map(Employee::getName)
                ).map(String::toUpperCase)
                .subscribe(System.out::println);
    }
}
