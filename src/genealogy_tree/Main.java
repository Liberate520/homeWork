package genealogy_tree;

import genealogy_tree.Human.Gender;
import genealogy_tree.service.Service;


import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service service = new Service();
        service.addHuman("Olga", Gender.Female, LocalDate.of(1987, 5, 13));
        service.addHuman("Petya", Gender.Male, LocalDate.of(1995, 10, 20));

        service.addHuman("Sasha", Gender.Female, LocalDate.of(1993, 2, 12));
        service.addHuman("Vasya", Gender.Male, LocalDate.of(1990, 7, 15));

        service.addHuman("Sabring", Gender.Female, LocalDate.of(1970, 1, 22));

        service.start();

    }

}
