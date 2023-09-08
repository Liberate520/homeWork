package ru.gb.Tree.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputData {
    private Scanner scanner;

    public InputData() {
        scanner =  new Scanner(System.in);
    }

    public String inputName(){
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()){
                return name;
            }else {
                System.out.print("Введена пустая строка.");
            }
        }
    }

    public String inputGender() {
        while (true) {
            System.out.print("Введите пол (male или female): ");
            String gender = scanner.nextLine();
            if (gender.equals("male") || gender.equals("female")) {
                return gender;
            } else {
                System.out.print("Ошибка! Введите male - для мужчин, female - для женщин. ");
            }
        }
    }

    public LocalDate inputBirthDate(){
        while (true) {
            System.out.print("Укажите дату рождения в формате 'YYYY/MM/DD': ");
            String birthDate = scanner.nextLine();
            if (birthDate.matches("^((19|20)[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")) {
                return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            }else if (birthDate.isEmpty()) {
                System.out.print("Введена пустая строка. ");
            } else {
                System.out.print("Ошибка! Введите дату рождения в формате 'YYYY/MM/DD'. ");
            }
        }
    }

    public LocalDate inputDeathDate(){
        while (true){
            System.out.print("Укажите дату смерти в формате 'YYYY/MM/DD': ");
            String deathDate = scanner.nextLine();
            if (deathDate.matches("^((19|20)[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")) {
                return LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            } else if  (deathDate.isEmpty()){
                return null;
            }else {
                System.out.print("Ошибка! Введите дату смерти в формате 'YYYY/MM/DD'. ");
            }
        }
    }

    public Integer inputMotherId(){
        while (true) {
            System.out.print("Укажите ID матери: ");
            String motherId = scanner.nextLine();
            if (motherId.isEmpty()) {
                return null;
            }else if (motherId.matches("[-+]?\\d+")) {
                return Integer.valueOf(motherId);
            } else {
                System.out.print("Ошибка, введено не число! ");
            }
        }
    }

    public Integer inputFatherId(){
        while (true) {
            System.out.print("Укажите ID отца: ");
            String fatherId = scanner.nextLine();
            if (fatherId.isEmpty()) {
                return null;
            } else if (fatherId.matches("[-+]?\\d+")) {
                return Integer.valueOf(fatherId);
            } else {
                System.out.println("Ошибка, введено не число! ");
            }
        }
    }
    public Integer inputDigits(){
        while (true) {
            String digit = scanner.nextLine();
            if (digit.matches("[-+]?\\d+")) {
                return Integer.valueOf(digit);
            } else {
                System.out.println("Ошибка, введено не число! ");
            }
        }
    }
    public int inputMenuChoice(int size){
        while (true) {
            String digit = scanner.nextLine();
            if (digit.matches("[-+]?\\d+") && Integer.parseInt (digit) < size) {
                return Integer.parseInt(digit);
            } else {
                System.out.println("Ошибка, попробуйте снова! ");
            }
        }
    }
}
