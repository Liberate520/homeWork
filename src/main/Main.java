package main;

import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.family_tree.FamilyTree;
import model.family_tree.TreeAppNaturally;
import service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    Service familyService = new Service();
    familyService.addHuman("John", "Vebster", Gender.Male,
            LocalDate.of(1965,12,2));
        familyService.addHuman("Anna", "Lubova", Gender.Female,
                LocalDate.of(1962,12,2));
        System.out.println(familyService.showIsNotInTree());
        System.out.println(familyService.showTree());



    }
}





