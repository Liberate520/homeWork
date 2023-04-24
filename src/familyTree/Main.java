package familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.saving.SaveAndLoad;
import familyTree.saving.Serial;
import familyTree.tree.FamilyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();
        SaveAndLoad saveLoad = new Serial();

        newTree.addNewHuman(new Human("Петров Пётр Петрович", Gender.male,
                "31.03.1973", "",
                "Петрова Ольга Александровна", "Петров Пётр Иванович",
                "Петрова Анастасия Валерьевна",
                "Петров Константин Петрович"));

        newTree.addNewHuman(new Human("Петров Константин Петрович", Gender.male,
                "04.11.1994", "",
                "Петрова Лидия Константиновна", "Петров Пётр Петрович",
                "Петрова Мария Фёдоровна",
                ""));

        System.out.println(newTree.searchHuman("Петров Константин Петрови").getAge());

        System.out.println(newTree.searchHuman("Петров Пётр Петрови").toString());
        saveLoad.savingTree(newTree, "familyTree.ser");
    }
}
