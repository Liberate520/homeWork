import java.util.GregorianCalendar;

import genealogy_tree.genealogy_tree.GenealogyTree;
import genealogy_tree.person.Gender;
import genealogy_tree.person.Person;
import genealogy_tree.person.comparators.PersonComparatorByAge;
import genealogy_tree.person.comparators.PersonComparatorByFullName;
import genealogy_tree.writer.FileHandler;
import genealogy_tree.writer.Writable;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person(
            "Иван", 
            "Иванович", 
            "Иванов",
            Gender.Male, 
            new GregorianCalendar(1970, 7, 21));
        Person maria = new Person(
            "Мария", 
            "Петровна", 
            "Иванова", 
            Gender.Female,
            new GregorianCalendar(1973, 5, 2));
        Person anna = new Person(
            "Анна", 
            "Ивановна", 
            "Иванова",
            Gender.Female, 
            new GregorianCalendar(1996, 2, 27));
        Person andrey = new Person(
            "Андрей", 
            "Иванович", 
            "Иванов", 
            Gender.Male,
            new GregorianCalendar(1999, 1, 17));
        Person andrey1 = new Person(
            "Андрей", 
            "Иванович", 
            "Иванов", 
            Gender.Male,
            new GregorianCalendar(1999, 1, 17));
            
        GenealogyTree<Person> tree = new GenealogyTree<>();
        tree.addElement(ivan);
        tree.addElement(maria);
        tree.addElement(anna);
        tree.addElement(andrey);
        tree.addElement(andrey);
        tree.addElement(andrey1);

        ivan.addChild(anna);
        ivan.addChild(andrey);
        anna.setParent(maria);
        andrey.setParent(maria);

        System.out.println("Дети Ивана:");
        for (Person child : ivan.getChildren()) {
            System.out.println(child.toString());
        }

        System.out.println("Родители Анны:\n" + anna.getParents().toString()); 
        
        Writable fileHandler = new FileHandler("tree.out");
        fileHandler.SaveObject(tree);
        @SuppressWarnings("unchecked")
        GenealogyTree<Person> treeFromFile = (GenealogyTree<Person>) fileHandler.LoadObject();
        if (treeFromFile != null){
            System.out.println("\n\nПрочитано из файла:\n");
            for (Person person : treeFromFile){
                System.out.println();
                System.out.println(person + "\n" + person.getParents().toString()); 
                System.out.println();
            }

            System.out.println("\n\nСортировка по возрасту:\n");
            for (Person person : treeFromFile.getTreeSortedBy(new PersonComparatorByAge())){
                System.out.println(person); 
            }

            System.out.println("\n\nАлфавитная сортировка:\n");
            for (Person person : treeFromFile.getTreeSortedBy(new PersonComparatorByFullName())){
                System.out.println(person); 
            }            
        }
    }
}
