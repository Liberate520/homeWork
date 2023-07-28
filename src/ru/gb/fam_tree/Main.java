package ru.gb.fam_tree;

import ru.gb.fam_tree.human.Genger;
import ru.gb.fam_tree.human.Human;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

        father.printChildrens(father);
    }
}
