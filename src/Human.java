import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human {
    // Описываем класс Human
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate birthDay;

    public List<Human> children;
// Конструктор без детей
    public Human(String name, String lastName, Gender gender, LocalDate birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;

    }
    // Конструктор с детьми(списком)

    public Human(String name, String lastName, Gender gender, LocalDate birthDay, List<Human> children) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.children = new ArrayList<>(children);

    }
    // Геттеры для полей класса

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    // Переопределяем метод toString класса Human
    @Override
    public  String toString() {
        return "имя:" + this.name + ", фамилия: " + this.lastName  + ", пол: " + this.gender + ", дата рождения: " + this.birthDay;


    }

}










