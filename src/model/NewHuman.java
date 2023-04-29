package model;
import java.util.Scanner;

class NewHuman {
    private FamilyTree<Human> familyTree;
    private Scanner scanner;

    NewHuman(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

     Human CreateHuman() {
        try {
            System.out.println("Для добавления нового родственника в список введите последовательно через запятую: \n" +
                    "имя, пол (M или F), имя отца, имя матери, год рождения");

            String newHuman = scanner.nextLine();
            newHuman = newHuman.replace(",","  ");
            newHuman = newHuman.replaceAll("\\s+"," ");
            String[] data = newHuman.split("[ ]");

            String name = data[0];
            Human father = familyTree.getHumanByName(data[2]);
            Human mother = familyTree.getHumanByName(data[3]);
            int birthYear = Integer.parseInt(data[4]);
            int id = familyTree.getLastId() + 1;
            return new Human(id, name, familyTree.getGender(data[1]), father, mother, birthYear);
        } catch (Exception e) {
            System.out.println("Ошибка ввода! " + e);
        }
         return null;
    }
}
