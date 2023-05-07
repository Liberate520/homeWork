package view;

import java.util.Scanner;

public class CollecterInfo {

    private Scanner scanner;
    private String name;
    private String birthDate;
    private String deathDate;
    private String motherName;
    private String fatherName;

    public CollecterInfo() {
        scanner = new Scanner(System.in, "cp866");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
    this.deathDate = deathDate;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public CollecterInfo getInfoFromUser() {
        CollecterInfo collecterInfo = new CollecterInfo();
        System.out.println("Введите имя и фамилию.");
        collecterInfo.setName(scanner.nextLine());

        System.out.println("Введите дату рождения в формате год-месяц-день.");
        collecterInfo.setBirthDate(scanner.nextLine());

        System.out.println("Введите дату смерти в формате год-месяц-день. Иначе введите 'нет'.");
        collecterInfo.setDeathDate(scanner.nextLine());

        System.out.println("Введите имя и фамилию матери, если она не известна введите 'нет'.");
        collecterInfo.setMotherName(scanner.nextLine());

        System.out.println("Введите имя и фамилию отца, если он не известен введите 'нет'.");
        collecterInfo.setFatherName(scanner.nextLine());
        return collecterInfo;
    }
}