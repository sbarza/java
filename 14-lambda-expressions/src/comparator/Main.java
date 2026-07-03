package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        record Person(String firstName, String lastName) {}
        record MyPerson(String name) {}

        record Student() {}

        Supplier<Student> s1 = () -> new Student();
        Supplier<Student> s = Student::new;


        BiFunction<String, String, Person> bf1 = (firstName, lastName) -> new Person(firstName, lastName);
        BiFunction<String, String, Person> bf2 = Person::new;

        StringBuilder name = new StringBuilder("João");

        Supplier<MyPerson> supplier =
                () -> new MyPerson(name.toString());

        MyPerson mp1 = supplier.get();

        name.append(" Silva");

        MyPerson mp2 = supplier.get();

        System.out.println(mp1);
        System.out.println(mp2);

        List<Person> list = new ArrayList<>(List.of(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort((o1, o2) -> );

        list.sort((p1, p2) -> p1.lastName.compareTo(p2.lastName));
        list.forEach(System.out::println);

        System.out.println("-".repeat(20));
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("-".repeat(20));
        list.sort(Comparator.comparing(Person::lastName)
                        .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("-".repeat(20));
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);

        Predicate<Object> notNull1 = Objects::nonNull;
        Predicate<Object> notNull2 = o -> Objects.nonNull(o);
        Predicate<Object> notNull3 = new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                return Objects.nonNull(o);
            }
        };
    }
}
