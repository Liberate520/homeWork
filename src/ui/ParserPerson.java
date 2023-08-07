package ui;

import familyTree.enums.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ParserPerson {
    // Класс для обработки ввода пользователя
    static boolean addPerson(Scanner scanner, Presenter presenter) {
        String name, year, month, day, dYear, dMonth, dDay;
        Gender gender;
        System.out.println("Введите имя:");
        name = scanner.nextLine();
        System.out.println("Введите пол m/f");
        gender = !scanner.nextLine().equalsIgnoreCase("m") ?
                Gender.Female : Gender.Male;
        System.out.println("Введите дату рождения: год, месяц, день");
        year = scanner.nextLine();
        month = scanner.nextLine();
        day = scanner.nextLine();
        System.out.println("Дата смерти известна? e/n");
        if (scanner.nextLine().equals("e")) {
            System.out.println("Введите дату смерти: год, месяц, день");
            dYear = scanner.nextLine();
            dMonth = scanner.nextLine();
            dDay = scanner.nextLine();
            return presenter.addPerson(name, gender,
                    LocalDate.of(
                            Integer.parseInt(year),
                            Integer.parseInt(month),
                            Integer.parseInt(day)),
                    LocalDate.of(
                            Integer.parseInt(dYear),
                            Integer.parseInt(dMonth),
                            Integer.parseInt(dDay)));
        } else {
            return presenter.addPerson(name, gender,
                    LocalDate.of(
                            Integer.parseInt(year),
                            Integer.parseInt(month),
                            Integer.parseInt(day)),
                    null);
        }
    }
}
