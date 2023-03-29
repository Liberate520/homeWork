import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        
        FamilyTree familyTree = new FamilyTree();
        List<Person> family = new ArrayList<>();

        Person person1 = new Person("Сергей", "Манеров", "18.04.1996");
        
        Person person2 = new Person("Оксана", "Вилкова", "12.10.1976");

        Person person3 = new Person("Денис", "Манеров", "11.10.1968");

        Person person4 = new Person("Вероника", "Вилкова", "04.03.2006");


        family.add(person1);
        family.add(person2);
        family.add(person3);
        family.add(person4);

        person2.addChild(person1);
        person3.addChild(person1);
        person2.addChild(person4);

        person1.setMother(person2);
        person1.setFather(person3);

        person4.setMother(person2);

        // person1.getFirstName();
        // person1.getSecondName();
        // person1.getDateOfBirth();
        // person1.getMother();
        // person1.getFather();
        // person1.getChildren();

        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);

        System.out.println(person1);
        // System.out.println(persona2);
        // System.out.println(family);
        // System.out.println(familyTree);


    }

}