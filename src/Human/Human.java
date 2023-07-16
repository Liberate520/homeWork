package Human;

import java.time.LocalDate;
import java.util.Scanner;

public class Human {
    public String name;
    private Human mother;
    private Human father;
    private Gender gender;

    LocalDate birthday;
    Status status;

    public Human(String name, int year, int month, int day, Gender gender, Status status) {
        this.name = name;
        this.birthday = LocalDate.of(year, month, day);
        this.gender = gender;
        this.status = status;
    }

    public void Parents(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ");
        stringBuilder.append(name);
        stringBuilder.append(", Пол: ");
        stringBuilder.append(gender);
        stringBuilder.append(", Дата рождения: ");
        stringBuilder.append(birthday);
        if (status.equals(Status.мертв)) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Обозначьте год смерти человека родившегося в %s: ", birthday.toString());
            int death = scanner.nextInt();
            int year = death - birthday.getYear();
            stringBuilder.append(", Возраст на момент смерти: ");
            stringBuilder.append(year);
        } else {
            LocalDate date = LocalDate.now();
            int year_d = date.getYear() - birthday.getYear();
            stringBuilder.append(", Возраст: ");
            stringBuilder.append(year_d);
        }
        stringBuilder.append(", Статус: ");
        stringBuilder.append(status);
        stringBuilder.append(", Родители: ");
        if (mother == null) {
            stringBuilder.append("неизвестно");
        } else {
            stringBuilder.append(mother.name);
            stringBuilder.append(" и ");
            stringBuilder.append(father.name);
        }
        return stringBuilder.toString();
    }
}
