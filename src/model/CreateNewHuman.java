package model;

import java.util.Scanner;

class CreateNewHuman {
    private FamilyTree<Human> familyTree;
    private Scanner scanner;

    CreateNewHuman(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

     Human readAndCreateHuman() {
        try {
            System.out.println("Для добавления в список введите последовательно через запятую(без пробелов): \n" +
                    "фамилия, имя, отчество, пол (м или ж), id отца, id матери, год рождения" +
                    "(в случае отсутствия id введите -1");

            String humanForAdding = scanner.next();
            String[] arrayDataOfHuman = humanForAdding.split("[,]");

            String nameFull = String.format("%s %s %s", arrayDataOfHuman[0], arrayDataOfHuman[1], arrayDataOfHuman[2]);
            Human father = familyTree.getHumanById(Integer.parseInt(arrayDataOfHuman[4]));
            Human mother = familyTree.getHumanById(Integer.parseInt(arrayDataOfHuman[5]));
            int birthYear = Integer.parseInt(arrayDataOfHuman[6]);
            int id = familyTree.getLastId() + 1;
            return new Human(id, nameFull, familyTree.getGender(arrayDataOfHuman[3]), father, mother, birthYear);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! " + e);
        }
         return null;
    }
}