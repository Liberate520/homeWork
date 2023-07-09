import human.Gender;
import human.Person;
import human.GenealogyTree;

import java.io.IOException;
import fileHandler.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

        person1.setDateOfBirth(21,12,1937);
        person1.setGender(Gender.Male);

        person2.setDateOfBirth(2,8,1948);
        person2.setDateOfDeath(3,11,2009);
        person2.setGender(Gender.Female);

        person3.setDateOfBirth(1,1,1954);
        person3.setDateOfDeath(1,1,2004);
        person3.setGender(Gender.Male);

        person4.setDateOfBirth(1,1,1954);
        person4.setDateOfDeath(1,1,1997);
        person4.setGender(Gender.Female);

        person5.setDateOfBirth(3,11,1968);
        person5.setGender(Gender.Female);

        person6.setDateOfBirth(27,5,1966);
        person6.setDateOfDeath(10,5,2009);
        person6.setGender(Gender.Male);

        person7.setDateOfBirth(27,12,1997);
        person7.setGender(Gender.Male);

        GenealogyTree tree = new GenealogyTree();
        tree.addPerson(person1);
        tree.addPerson(person2);
        tree.addPerson(person3);
        tree.addPerson(person4);
        tree.addPerson(person5);
        tree.addPerson(person6);
        tree.addPerson(person7);

//        Работаем с деревом

        System.out.println("Генеалогическое дерево:");
        tree.showTree();
        tree.findPerson("Виктор", "Николаев");

//        Сохраняем дерево в текстовый файл

        Writeable save = new SaveLoadFile();
        save.saveToFile("family_tree.txt", tree);


//        Загружаем дерево из текстового файла

        GenealogyTree loadedTree = save.loadFromFile("family_tree.txt");
        Person person8 = new Person("Иван", "Иванов");
        person8.setDateOfBirth(1,1,2031);
        person8.setGender(Gender.Male);
        person7.addChild(person8);
        loadedTree.addPerson(person8);

        System.out.println("Сортировка по имени:");
        loadedTree.sortByName(); // сортировка по имени
        loadedTree.showTree();
        System.out.println("Сортировка по дате рождения:");
        loadedTree.sortByBirthDate(); // сортировка по дате рождения
        loadedTree.showTree();
    }
}