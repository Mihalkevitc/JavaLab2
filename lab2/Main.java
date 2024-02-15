package lab2;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        //Создаём список объектов класса Human
        List<Human> humans = List.of(
                new Human(25, "Tom", "Cruse", LocalDate.of(2001, 5, 10), 65),
                new Human(30, "Kile", "Riki", LocalDate.of(1991, 8, 15), 73),
                new Human(22, "Den", "Snow", LocalDate.of(2003, 3, 20), 55)
        );

        //Выводим изначальный список объектов
        System.out.println("Список людей:");
        humans.forEach(System.out::println);

        //Создаём поток
        Stream<Human> stream = humans.stream();

        System.out.println();
        System.out.println("Список дюдей, родившихся после 24 июня 2000 года:");

        //Фильтруем поток по дате рождения и выводим результат фильтрации
        stream.filter(human -> human.getBirthDate().isAfter(LocalDate.of(2000, 6, 24)))
                .forEach(System.out::println);

        //Создаём поток
        Stream<Human> stream1 = humans.stream();

        System.out.println("\nСписок людей, отсортированный по фамилии:");
        //Фильтруем поток по фамилии и выводим результат
        stream1.sorted(Comparator.comparing(Human::getLastName))
                .forEach(System.out::println);

        //Создаём поток
        Stream<Human> stream2 = humans.stream();

        System.out.println("\nСписок людей, отсортированный по имени:");
        //Фильтруем поток по имени и выводим результат
        stream2.sorted(Comparator.comparing(Human::getFirstName))
                .forEach(System.out::println);

        // Находим сумму всех возрастов
        int totalAge = humans.stream()
                .map(Human::getAge)
                .reduce(0, (x, y) -> x + y);
//                .reduce(0, Integer::sum);

        //Выводим результат суммирования
        System.out.println();
        System.out.println("Сумма всех возрастов: " + totalAge);

    }

    }

