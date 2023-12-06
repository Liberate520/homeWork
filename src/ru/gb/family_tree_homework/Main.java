package ru.gb.family_tree_homework;

import ru.gb.family_tree_homework.family_tree.FamilyTree;
import ru.gb.family_tree_homework.file_handler.FileHandler;
import ru.gb.family_tree_homework.human.Gender;
import ru.gb.family_tree_homework.human.Human;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = tree();
        save(familyTree);
        System.out.println(familyTree);

        FamilyTree<Human> newTree = load();
        System.out.println(newTree);
        Iterator<Human> treeIterator = newTree.iterator();
        System.out.println(treeIterator.next());
        System.out.println(treeIterator.hasNext());
        newTree.sortByAge();
        System.out.println(newTree);
        newTree.sortByName();
        System.out.println(newTree);
        newTree.sortByBirthDate();
        System.out.println(newTree);
    }

    private static FamilyTree<Human> load() {
        String path = "src/ru/gb/family_tree_homework/file_handler/human_tree_1.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read(path);
    }

    private static void save(FamilyTree<Human> familyTree){
        String path = "src/ru/gb/family_tree_homework/file_handler/human_tree_1.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, path);
    }

    static FamilyTree<Human> tree(){
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human son = new Human("Nikita", Gender.Male,LocalDate.of(2001, 5, 11));
        Human mother = new Human("Anna", Gender.Female, LocalDate.of(1978, 12, 7));
        Human father = new Human("Alexander", Gender.Male, LocalDate.of(1978, 1, 1));
        Human daughter = new Human("Kristina", Gender.Female, LocalDate.of(2003, 6, 15));

        son.addParent(father);
        son.addParent(mother);
        daughter.addParent(father);
        daughter.addParent(mother);
        familyTree.setWedding(father, mother);
        familyTree.addFamilyMember(son);
        familyTree.addFamilyMember(mother);
        familyTree.addFamilyMember(father);
        familyTree.addFamilyMember(daughter);
        return familyTree;
    }
}