package Homeworks.homeWork.src.main.java;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree family = new FamilyTree();
        LocalDate h1Born = LocalDate.of(1998, 1, 1);
        LocalDate h2Born = LocalDate.of(2000, 2, 28);
        LocalDate h3Born = LocalDate.of(2018, 4, 23);
        LocalDate h4Born = LocalDate.of(2020, 5, 23);
        Gender man = Gender.Мужского;
        Gender woman = Gender.Женского;
        Human h1 = new Human("Иван", "Иванов", h1Born, man);
        Human h2 = new Human("Ольга", "Иванова", h2Born, woman);
        Human h3 = new Human("Дамир", "Иванов", h3Born, man);
        Human h4 = new Human("Соня", "Иванова", h4Born, woman);
        h3.setFather(h1);
        h3.setMother(h2);
        h4.setFather(h1);
        h4.setMother(h2);
        h1.addChildren(h3);
        h1.addChildren(h4);
        h2.addChildren(h3);
        h2.addChildren(h4);
        family.addHuman(h1);
        family.addHuman(h2);
        family.addHuman(h3);
        family.addHuman(h4);
        System.out.println(family.showFamilyTree());
        //System.out.println(h1.showChildren());
        System.out.println(h2.showChildren());
    }
}
