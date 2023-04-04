import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import file.OutInput;
import file.Slfamailytree;
import human.Human;
import tree.FamilyTree;
import tree.Sorts;
import tree.Tree;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        Human human1 = new Human("Екатерина", "ж", 1974);
        Human human2 = new Human("Галина", "ж", 1941);
        Human human3 = new Human("Владимир", "м", 1935);
        Human human4 = new Human("Иван", "м", 1905);
        Human human5 = new Human("Евфалия", "ж", 1907);
        Human human6 = new Human("Дарья", "ж", 1976);

        human1.setMother(human2);
        human1.setFather(human3);
        human6.setFather(human3);
        human6.setMother(human2);
        human2.setMother(human5);
        human3.setFather(human4);

        Tree<Human> famailytree = new FamilyTree<>();

        famailytree.addpeople(human1, human2, human3);
        famailytree.addpeople(human2, human5, null);
        famailytree.addpeople(human6, human2, human3);
        famailytree.addpeople(human3, null, human4);
        famailytree.addpeople(human4, null, null);
        famailytree.addpeople(human5, null, null);
        System.out.println(famailytree);

        for(Human human: famailytree){
            System.out.println(human);
        }

        Sorts<Human> sorts = new Sorts<>(famailytree);
        sorts.SortbyName();
        System.out.println();
        for(Human human: famailytree){
            System.out.println(human);
        }

        sorts.SortbyId();
        System.out.println();
        for(Human human: famailytree){
            System.out.println(human);
        }

        sorts.SortbyChild();
        System.out.println();
        for(Human human: famailytree){
            System.out.println(human);
        }

        sorts.SortbyBirthyear();
        System.out.println();
        for(Human human: famailytree){
            System.out.println(human);
        }
        System.out.println("Введите имя человека, которого нужно найти: ");
        String name1 = scan.nextLine();
        Human humanf = new Human("1", "ж", 1900);
        humanf = famailytree.findHuman(name1, humanf);

        if (humanf.getName().equals("1")) {
            System.out.printf("Человека с именем %s в этом фамильном дереве нет.\n", name1);
        } else {
            System.out.println(humanf);
        }
        scan.close();

        OutInput<Human> saveload = new Slfamailytree<>();
        saveload.save(famailytree);
        famailytree = (Tree<Human>) saveload.load();
        System.out.println(famailytree);  
    }
}