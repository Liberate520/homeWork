package ru.gb.fam_tree;

import ru.gb.fam_tree.file_handler.FileHandler;
import ru.gb.fam_tree.human.Genger;
import ru.gb.fam_tree.human.Human;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human mother = new Human("Svetlana", "Vahterova", Genger.Female);
        Human father = new Human("Aleksei", "Vahterov", Genger.Male);
        mother.setSpouse(father);
        father.setSpouse(mother);

        Human son = new Human("Zahar", "Vahterov", Genger.Male, mother, father);
        Human olderDaughter = new Human("Alisa", "Vahterova", Genger.Female, mother, father);
        Human youngerDougher = new Human("Maria", "Vahterova", Genger.Female, mother, father);

        ArrayList<Human> childrens = new ArrayList<>();
        childrens.add(son);
        childrens.add(olderDaughter);
        childrens.add(youngerDougher);

        mother.setChildrens(childrens);
        father.setChildrens(childrens);

        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(son);
        familyTree.addHuman(olderDaughter);
        familyTree.addHuman(youngerDougher);

        List<Human> humanList= new ArrayList<>();
        humanList.add(father);
        humanList.add(mother);
        humanList.add(son);
        humanList.add(olderDaughter);
        humanList.add(youngerDougher);

        //System.out.println(familyTree.getChildrensNames(father));

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeFamilyTree(familyTree,"family.dat");

        System.out.println(fileHandler.readFamilyTree("family.dat"));
    }
}
