package src.ui;


import java.util.HashMap;
import java.util.Scanner;

public class ConsoleForms {
    private Scanner scanner;
    private HashMap<String, String> result;

    public HashMap<String, String> findForm() {
        scanner = new Scanner(System.in);
        System.out.println("Будут запрошены критерии поиска, если критерий не нужен, укажите * ");
        result = intermediateForm();
        System.out.print("Укажите от какой даты нужно искать дату рождения: ");
        result.put("dateOfBornFrom", scanner.next());
        System.out.print("Укажите до какой даты нужно искать дату рождения: ");
        result.put("dateOfBornTo", scanner.next());
        System.out.print("Укажите от какой даты нужно искать дату смерти: ");
        result.put("dateOfDeathFrom", scanner.next());
        System.out.print("Укажите до какой даты нужно искать дату смерти: ");
        result.put("dateOfDeathTo", scanner.next());
        System.out.print("Укажите место рождения: ");
        result.put("placeOfBirth", scanner.next());

        return starFix(result);
    }

    private HashMap<String, String> starFix(HashMap<String, String> hashMap) {
        for (String str :
                hashMap.keySet()) {
            if (hashMap.get(str).equals("*")) {
                hashMap.replace(str, "");
            }
        }
        return hashMap;
    }

    public HashMap<String, String> humanForm() {
        result = intermediateForm();
        scanner = new Scanner(System.in);
        System.out.print("Укажите дату рождения в формате dd.mm.YYYY: ");
        result.put("dateOfBorn", scanner.next());
        System.out.print("Укажите дату смерти в формате dd.mm.YYYY(или укажите 0): ");
        result.put("dateOfDeath", scanner.next());
        System.out.print("Укажите место рождения: ");
        result.put("placeOfBirth", scanner.next());
        return result;
    }

    private HashMap<String, String> intermediateForm() {
        scanner = new Scanner(System.in);
        result = new HashMap<>();
        System.out.print("Укажите пол Male/Female: ");
        result.put("gender", scanner.next());
        System.out.print("Укажите имя: ");
        result.put("firstName", scanner.next());
        System.out.print("Укажите отчество: ");
        result.put("patronymic", scanner.next());
        System.out.print("Укажите фамилию: ");
        result.put("lastName", scanner.next());
        return result;
    }
}
