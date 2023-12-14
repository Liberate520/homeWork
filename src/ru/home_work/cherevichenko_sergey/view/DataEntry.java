package ru.home_work.cherevichenko_sergey.view;

import ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree.human.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DataEntry {
    public String name;
    public Gender gender;
    public LocalDate birthDay;
    public LocalDate dateDeath;
    public LocalDateTime localDateTime;
    Scanner scanner;

    public DataEntry() {
        localDateTime = LocalDateTime.now();
        scanner = new Scanner(System.in);
    }

    public String name(String name1) {
        System.out.println(name1);
        name = scanner.nextLine();
        return name;
    }


    public Gender gender() {
        System.out.println("Выберите пол. Введите М или Ж:  ");
        String gender1 = scanner.nextLine();
        if (gender1.equalsIgnoreCase("м"))
            return gender = Gender.MALE;
        else
            return gender = Gender.FEMALE;
    }

    public LocalDate birthDay() {
        System.out.println("Введите год рождения в формате ГГГГ: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения в формате ММ: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения в формате ДД:  ");
        int day = Integer.parseInt(scanner.nextLine());
        return birthDay = LocalDate.of(year, month, day);
    }

    public LocalDate dateDeath() {
        System.out.println("Жив ли человек? Д/Н");
        String alive = scanner.nextLine();
        if (alive.equalsIgnoreCase("д"))
            return null;
        else {
            System.out.println("Введите год смерти в формате ГГГГ: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите месяц смерти в формате ММ: ");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите день смерти в формате ДД:  ");
            int day = Integer.parseInt(scanner.nextLine());
            return dateDeath = LocalDate.of(year, month, day);
        }
    }

    public String timeDay() {
        int hour = localDateTime.getHour();
        StringBuilder str = new StringBuilder();
        if (hour >= 0 && hour <= 6)
            str.append("Доброй ночи!");
        else if (hour > 6 && hour <= 12)
            str.append("Доброе утро!");
        else if (hour > 12 && hour <= 18)
            str.append("добрый день!");
        else {
            str.append("Добрый вечер!");
        }
        return str.toString();
    }

}
