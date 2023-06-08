package Hw.sem1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Person
        Person john = new Person("John", Gender.MALE, LocalDate.of(1980, 5, 15), null);
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1982, 9, 22), null);
        Person tom = new Person("Tom", Gender.MALE, LocalDate.of(2005, 3, 10), null);


        FamilyTree familyTree = new FamilyTree(john);


        familyTree.addChild(john, tom);


        tom.setFather(john);
        tom.setMother(jane);

        List<Person> allMembers = familyTree.getAllMembers();
        for (Person person : allMembers) {
            System.out.println("Имя: " + person.getName());
            System.out.println("Пол: " + person.getGender());
            System.out.println("День рождения: " + person.getBirthDate());
            System.out.println("День смерти: " + person.getDeathDate());
            System.out.println("Отец: " + (person.getFather() != null ? person.getFather().getName() : "Unknown"));
            System.out.println("Мать: " + (person.getMother() != null ? person.getMother().getName() : "Unknown"));
            System.out.println("Дети: " + person.getChildren().size());
            System.out.println("--------------------");
        }
    }
}