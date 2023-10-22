import java.util.GregorianCalendar;

import ru.gb.family_tree.GenealogyTree;
import ru.gb.family_tree.person.Gender;
import ru.gb.family_tree.person.Person;

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
            
        GenealogyTree tree = new GenealogyTree();
        tree.addPerson(ivan);
        tree.addPerson(maria);
        tree.addPerson(anna);
        tree.addPerson(andrey);
        tree.addPerson(andrey);
        tree.addPerson(andrey1);

        ivan.addChild(anna);
        ivan.addChild(andrey);
        anna.setParent(maria);
        andrey.setParent(maria);

        System.out.println("Дети Ивана:");
        for (Person child : ivan.getChildren()) {
            System.out.println(child.toString());
        }

        System.out.println("Родители Анны:\n" + anna.getParents().toString());        
    }
}
