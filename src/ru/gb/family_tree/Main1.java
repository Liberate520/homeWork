package ru.gb.family_tree;

import ru.gb.family_tree.Family.Gender;
import ru.gb.family_tree.Family.Human;
import ru.gb.family_tree.Tree.FamilyTree;
import ru.gb.family_tree.Tree.Parent;

public class Main1 {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        // Human notHuman = null;
        Human human1 = new Human("Петрова Наталья Ивановна", Gender.Female,"12.12.1945", "11.11.2010");
        Human human2 = new Human("Петров Михаил Сергеевич", Gender.Male,"12.06.1945", "21.12.2011");
        Human human3 = new Human("Петров Сергей  Михайлович", Gender.Male, "12.12.1967", "No");
        Human human4 = new Human("Иванова Анна Михайловна", Gender.Female,"12.12.1967","No");
        Human human5 = new Human("Куликова Елена Анатольевна", Gender.Female,"12.10.1964","No");
        Human human6 = new Human("Иванов Aндрей Юрьевич", Gender.Male, "12.10.1964", "No");
        Human human7 = new Human("Петров Сергей Сергеевич", Gender.Male, "11.02.1989", "No");

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        //List<Human> children1 = List.of(human3, human4);
        //List<Human> children2 = List.of(human7);
        System.out.println(familyTree);
    }
}
