import model.familyTree.ConnectionType;
import model.familyTree.Connections;
import model.person.Gender;
import model.person.Person;
import model.service.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service<Person> service = makeTree();
        for (Map.Entry<Person, Connections<Person>> item :
                service) {
            System.out.println(item);
        }
        System.out.println(Arrays.toString(Gender.values()));
        LocalDate date = getDate();
        System.out.println(date);
    }

    public static Service<Person> makeTree() {
        Service<Person> service = new Service<>();
        Person egor = new Person("Егор", "Меньшиков", "Леонидович",
                Gender.MALE, LocalDate.of(1986, 3, 13));
        Person petr = new Person("Петр", "Меньшиков", "Леонидович",
                Gender.MALE, LocalDate.of(1988, 8, 11));
        Person marina = new Person("Марина", "Меньшикова", "Рудольфовна",
                Gender.FEMALE, LocalDate.of(1957, 11, 30));
        Person leonid = new Person("Леонид", "Меньшиков", "Иеронимович",
                Gender.MALE, LocalDate.of(1954, 10, 18));
        service.addPerson(egor);
        service.addPerson(petr);
        service.addPerson(leonid);
        service.addPerson(marina);
        service.putConnection(egor, ConnectionType.PARENT, marina);
        service.putConnection(egor, ConnectionType.SIBLING, petr);
        service.putConnection(egor, ConnectionType.PARENT, leonid);
        service.putConnection(marina, ConnectionType.SPOUSE, leonid);
        service.putConnection(marina, ConnectionType.CHILD, petr);
        service.putConnection(leonid, ConnectionType.CHILD, petr);
        return service;
    }

    public static Service<Person> readTree() {
        Service<Person> result = new Service<>();
        result.read();
        return result;
    }

    public static LocalDate getDate() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty()) return null;
        return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}

