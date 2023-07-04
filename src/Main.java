import human.Person;
import human.GenealogyTree;

import java.io.IOException;

import fileHandler.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Виктор", "Николаев");
        Person person2 = new Person("Галина", "Николаева");
        Person person3 = new Person("Николай", "Сиденко");
        Person person4 = new Person("Валентина", "Сиденко");
        Person person5 = new Person("Елена", "Сиденко");
        Person person6 = new Person("Александр", "Сиденко");
        Person person7 = new Person("Георгий", "Сиденко");

        person1.addChild(person5);
        person2.addChild(person5);
        person3.addChild(person6);
        person4.addChild(person6);
        person5.addChild(person7);
        person6.addChild(person7);

        person1.setDateOfBirth("21.12.1937");
        person1.setGender("Male");

        person2.setDateOfBirth("02.08.1948");
        person2.setDateOfDeath("2009");
        person2.setGender("Female");

        person3.setDateOfBirth("01.01.1954");
        person3.setDateOfDeath("2004");
        person3.setGender("Male");

        person4.setDateOfBirth("01.01.1954");
        person4.setDateOfDeath("1997");
        person4.setGender("Female");

        person5.setDateOfBirth("03.11.1968");
        person5.setGender("Female");

        person6.setDateOfBirth("27.05.1966");
        person6.setDateOfDeath("10.05.2009");
        person6.setGender("Male");

        person7.setDateOfBirth("27.12.1997");
        person7.setGender("Male");

        GenealogyTree tree = new GenealogyTree();
        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);
        tree.addPerson(person5);
        tree.addPerson(person6);
        tree.addPerson(person7);

//        Работаем с деревом

        tree.showTree();
        tree.findPerson("Виктор", "Николаев");
        tree.printGenealogyTree(person1);

//        Сохраняем дерево в текстовый файл

        Writeable save = new SaveLoadFile();
        try {
            save.saveToFile("family_tree.txt", tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Загружаем дерево из текстового файла

        System.out.println();

        Writeable load = new SaveLoadFile();
        try {
            GenealogyTree loadedTree = load.loadFromFile("family_tree.txt");
            Person person8 = new Person("Иван", "Иванов");
            person7.addChild(person8);
            loadedTree.addPerson(person8);
            loadedTree.printGenealogyTree(person1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}