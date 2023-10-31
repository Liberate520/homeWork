import Human.*;
import Service.*;
import familyTree.*;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Service service = new Service();

        service.addHuman("Misha", LocalDate.of(1960, 12,15), Gender.male);
        service.addHuman("Natasha", LocalDate.of(1959, 4,20), Gender.female);
        service.addHuman("Kate", LocalDate.of(1990, 5,3), Gender.female);
        service.addHuman("Anna", LocalDate.of(1959, 2,20), Gender.female);

        service.save();

        service.read();

        System.out.println(service);

        service.sortByName();
        System.out.println(service);

        service.sortByAge();
        System.out.println(service);
    }
}
