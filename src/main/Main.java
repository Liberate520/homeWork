package main;

import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //TODO: Уйти от использования объекта Human, задавать дерево напрямую через familyTree
        Human sergei = new Human("Sergei", "Petrov", Gender.Male,
                LocalDate.of(1989, 1, 1), LocalDate.of(2015, 12, 31));
        Human vaselisa = new Human("Vaselisa", "Petrova", Gender.Female,
                LocalDate.of(1990, 1, 1));
        Human anna = new Human("Anna", "Petrova", Gender.Female,
                LocalDate.of(1965, 1, 1));
        Human vasilii = new Human("Vasilii", "Petrov", Gender.Male,
                LocalDate.of(1987, 1, 1));
        Human sofia = new Human("Sofia", "Legneva", Gender.Female,
                LocalDate.of(2008, 2, 3));
        Human ivan = new Human("Ivan", "Petrov", Gender.Male,
                LocalDate.of(2013, 12, 3));
        FamilyTree familyPetrovi = new FamilyTree();
        familyPetrovi.setSpouse(sergei, vaselisa);
        familyPetrovi.setChildren(anna, vasilii);
        familyPetrovi.setMother(sergei, anna);
        familyPetrovi.setMother(sofia, vaselisa);
        familyPetrovi.setFather(sofia, sergei);

/*        System.out.println(familyPetrovi);
        System.out.println(sergei);
        System.out.println("");
        System.out.println(anna);*/
        //System.out.println(familyPetrovi.showTree());

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeObject(familyPetrovi, "familyPetrovi");
        FamilyTree recordTest = (FamilyTree) fileHandler.readObject("familyPetrovi");
        System.out.println(recordTest);

    }


}
