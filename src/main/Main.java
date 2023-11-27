package main;

import family_tree.FamilyTree;
import family_tree.Genders;
import family_tree.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //TODO: Уйти от использования объекта Human, задавать дерево напрямую через familyTree
        Human sergei = new Human("Sergei", "Petrov", Genders.Male,
                LocalDate.of(1989, 1, 1), LocalDate.of(2015, 12, 31));
        Human vaselisa = new Human("Vaselisa", "Petrova", Genders.Female,
                LocalDate.of(1990, 1, 1));
        Human anna = new Human("Anna", "Petrova", Genders.Female,
                LocalDate.of(1965, 1, 1));
        Human vasilii = new Human("Vasilii", "Petrov", Genders.Male,
                LocalDate.of(1987, 1, 1));
        Human sofia = new Human("Sofia", "Legneva", Genders.Female,
                LocalDate.of(2008, 2, 3));
        Human ivan = new Human("Ivan", "Petrov", Genders.Male,
                LocalDate.of(2013, 12, 3));
        FamilyTree familyPetrovi = new FamilyTree();
        familyPetrovi.setSpouse(sergei, vaselisa);
        familyPetrovi.setChildren(anna, vasilii);
        familyPetrovi.setMother(sergei, anna);
        familyPetrovi.setMother(sofia, vaselisa);
        familyPetrovi.setFather(sofia, sergei);

        System.out.println(familyPetrovi);
        System.out.println(sergei);
        System.out.println("");
        System.out.println(anna);


    }
}
