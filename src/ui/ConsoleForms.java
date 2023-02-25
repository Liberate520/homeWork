package src.ui;

import src.Validation;

import java.util.Scanner;

public class ConsoleForms {

    public String[] findForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Будут запрошены критерии поиска, если критерий не нужен, укажите * ");
        System.out.print("Укажите пол: ");
        String gender = scanner.next();
        System.out.print("Укажите имя: ");
        String firstName = scanner.next();
        System.out.print("Укажите отчество: ");
        String patronymic = scanner.next();
        System.out.print("Укажите фамилию: ");
        String lastName = scanner.next();
        System.out.print("Укажите от какой даты нужно искать дату рождения: ");
        String dateOfBornFrom = scanner.next();
        System.out.print("Укажите до какой даты нужно искать дату рождения: ");
        String dateOfBornTo = scanner.next();
        System.out.print("Укажите от какой даты нужно искать дату смерти: ");
        String dateOfDeathFrom = scanner.next();
        System.out.print("Укажите до какой даты нужно искать дату смерти: ");
        String dateOfDeathTo = scanner.next();
        System.out.print("Укажите место рождения: ");
        String placeOfBirth = scanner.next();
        String[] result = {gender, firstName, patronymic, lastName, dateOfBornFrom, dateOfBornTo,
                dateOfDeathFrom, dateOfDeathTo, placeOfBirth};
        return starFix(result);
    }

    private String[] starFix(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*")) {
                arr[i] = "";
            }
        }
        return arr;
    }
}
