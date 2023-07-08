package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Person spouse;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id)
                .append(", имя: ").append(name)
                .append(", пол: ").append(gender)
                .append(", возраст: ").append(calculateAge());

        if (spouse != null) {
            sb.append(", супруг(а): ").append(spouse.getName());
        } else {
            sb.append(", супруг(а): нет");
        }

        if (mother != null) {
            sb.append(", мать: ").append(mother.getName());
        } else {
            sb.append(", мать: неизвестна");
        }

        if (father != null) {
            sb.append(", отец: ").append(father.getName());
        } else {
            sb.append(", отец: неизвестен");
        }

        if (children.isEmpty()) {
            sb.append(", дети: отсутствуют");
        } else {
            sb.append(", дети: ");
            for (Person child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length()); // Удаление последней запятой и пробела
        }

        return sb.toString();
    }

    int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthDate.getYear();
        if (currentDate.getMonthValue() < birthDate.getMonthValue() || (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }

    private String getSpouseName() {
        // Логика получения имени супруга/супруги
        return null;
    }

    private String getMotherName() {
        // Логика получения имени матери
        return null;
    }

    private String getFatherName() {
        // Логика получения имени отца
        return null;
    }

    private String getChildrenNames() {
        // Логика получения имен детей
        return null;
    }
}
