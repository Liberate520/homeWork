package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.IOException;
import java.time.LocalDate;

import ru.gb.family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        familyTree - этот объект будет в единственном экземпл€р,
        а уже внутри него будет ArrayList, т.е. список из людей
         */
        FamilyTree familyTree = new FamilyTree();

        //создаем объекты human и каждого добавл€ем в familyTree
        Human human1 = new Human("Ivanov Ivan Ivanovich", Gender.Male, LocalDate.of(1984, 12, 31));
        familyTree.addHuman(human1);

        Human human2 = new Human("Petrov Pyotr Venediktovich", Gender.Male, LocalDate.of(1976, 06, 11));
        familyTree.addHuman(human2);

        Human human3 = new Human("Semyonov Semyon Semyonovich", Gender.Male, LocalDate.of(1964, 01, 16));
        familyTree.addHuman(human3);

        Human human4 = new Human("Venediktov Venedikt Venediktovich", Gender.Male, LocalDate.of(1949, 12, 3));
        familyTree.addHuman(human4);

        Human human5 = new Human("Statsenko Elena Gennadievna", Gender.Male, LocalDate.of(1952, 04, 26));
        familyTree.addHuman(human5);

        Human human6 = new Human("Venediktova Olga Venediktovna", Gender.Female, LocalDate.of(1969, 06, 27));
        familyTree.addHuman(human6);

        //добавим родителей
        human2.setFather(human4);
        human2.setMother(human5);

        human6.setFather(human4);
        human6.setMother(human5);


        //выведем фамильное древо
        System.out.println(familyTree);

        //перенести в FamilyTree
        System.out.println("All peoples are created: " + Human.getCounter() + "\n");

        //save family tree
        save(familyTree);

        //
        FamilyTree familyTree1 = load();
        System.out.print("Loaded data: \n"+familyTree1.toString()+"\n");



    }

    private static void save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        String path="src/ru.gb.family_tree/family_tree.txt";
        fileHandler.save(familyTree, path);
    }

    private static FamilyTree load(){
        FileHandler fileHandler = new FileHandler();
        String path="src/ru.gb.family_tree/family_tree.txt";
        return (FamilyTree) fileHandler.read(path);
    }
}
