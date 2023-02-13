package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Human {
    /** Ф.И.О. */
    private String name;
    /** Пол */
    private Gender gender;
    /** Дата рождения */
    private LocalDate dateOfBirth;
    private Object dateOfDeath;

    {
        dateOfDeath = "Да здравствует!";
    }


    //----------------------------------------------------------------------------------------------------------------
    public Human(Scanner scanner){
        System.out.println("Введите Ф.И.О.");
        this.name = scanner.nextLine();
        setGender(scanner);
        setDateOfBirth(scanner);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Object dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }


    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;

    }
    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Human(String name) {
        this.name = name;
    }
    //-----------------------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Scanner scanner) {
        System.out.println("1 - Мужчина");
        System.out.println("2 - Женщина");
        String input = scanner.nextLine();
        if (input.equals("1")){
            this.gender = Gender.male;
        } else{
            this.gender = Gender.female;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Scanner scanner) {
        System.out.println("Ведите дату рождения в формате -день%месяц%год-");
        ArrayList <String> date = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        this.dateOfBirth = LocalDate.of(Integer.parseInt(date.get(2)),
                Integer.parseInt(date.get(1)), Integer.parseInt(date.get(0)));
    }


    public Object getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Scanner scanner) {  //
        System.out.println("Ведите дату смерти в формате -день%месяц%год-");
        ArrayList <String> date = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        this.dateOfDeath = LocalDate.of(Integer.parseInt(date.get(2)),
                Integer.parseInt(date.get(1)), Integer.parseInt(date.get(0)));
    }

    public static void printNameHuman(ArrayList<Human> list) {  // Печать имен Human
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, list.get(i).getName());
        }
    }
    public static void printHuman(ArrayList<Human> list, int indexH){  // Печать Human
            System.out.printf("%s, %s, %s, %s%n", list.get(indexH).getName(), list.get(indexH).getGender(),
                    list.get(indexH).getDateOfBirth(), list.get(indexH).getDateOfDeath());
            System.out.println();
    }
    public static void SuperPrintNameHuman(ArrayList<Human> list) {  // Печать имен Human
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d - %s, %s, Дата рождения %s ", i + 1, list.get(i).getName(), list.get(i).getGender(),
                    list.get(i).getDateOfBirth());
            if (list.get(i).dateOfDeath != "Да здравствует!"){
                System.out.printf("Дата смерти %s", list.get(i).dateOfDeath);
            }
            System.out.println();
        }
        System.out.println();
    }
}
