package oop_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Person implements Serializable {

    private String full_name;
    private String year_of_birth;
    private String sex;
    private ArrayList<Person> person = new ArrayList<>(); // коллекция людей

    public Person(String full_name, String year_of_birth, String sex) {
        this.full_name = full_name;
        this.year_of_birth = year_of_birth;
        this.sex = sex;
    }

    public Person() {

    }

    public ArrayList<Person> getPerson() {
        return person;
    }

    public void setPerson(ArrayList<Person> person) {
        this.person = person;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }


    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }


    public String printInfoPerson() {
        System.out.printf("%s, %s г.р, пол: %s ", full_name, year_of_birth, sex);
        return "";
    }

    @Override
    public String toString() {
        return full_name + " " + year_of_birth + " " + sex;
    }
    // метод парсинга полного имени
    public String userInputStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.println(msg);
            try {
                inputStr = sc.nextLine();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }

    public void addPerson(Person human) {
        person.add(human);
    }


}