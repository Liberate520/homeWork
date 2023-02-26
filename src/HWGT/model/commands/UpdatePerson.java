package HWGT.model.commands;

import HWGT.model.FamilyTree;

import java.util.Scanner;

public class UpdatePerson {
    private FamilyTree familyTree;

    public UpdatePerson(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void dataInFamilyTree(FamilyTree familyTree) {
        CheckName checkName = new CheckName(familyTree);
        String personName;
        Integer birthDate;
        Integer deathDate;

        System.out.println("Введите имя(без пробелов)");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
        personName = scanner1.next();
        if (checkName.getCheck(familyTree, personName)) {
            System.out.println("человек найден \n");
            System.out.println(familyTree.getPerson(personName));
            System.out.println("введите год рождения или '0'\n");
            birthDate = scanner1.nextInt();
            if (birthDate > 0) {
                familyTree.getPerson(personName).setDateOfBirth(birthDate);
            }
            System.out.println("введите год смерти или '0'\n");
            deathDate = scanner1.nextInt();
            if (deathDate > 0) {
                familyTree.getPerson(personName).setDateOfDeath(deathDate);
            }
            System.out.println(familyTree.getPerson(personName));
        }
    }
}
