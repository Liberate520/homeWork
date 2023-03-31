import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class Main {

    static FamilyTree familyTree = new FamilyTree();
    
    static Person person1 = new Person("Сергей", "Манеров", "18.04.1996");
            
    static Person person2 = new Person("Оксана", "Вилкова", "12.10.1976");

    static Person person3 = new Person("Денис", "Манеров", "11.10.1968");

    static Person person4 = new Person("Вероника", "Вилкова", "04.03.2006");


        
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        

        person2.addChild(person1);
        person3.addChild(person1);
        person2.addChild(person4);

        person1.setAlive(true);
        person2.setAlive(true);
        person3.setAlive(true);
        person4.setAlive(true);


        
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

        // System.out.println(person1);
        // System.out.println(person2);
        // System.out.println(person3);
        // System.out.println(person4);


        // System.out.println(family);
        // System.out.println(familyTree);
        
        Interface.Interface();
        FamilyTree.getFamilyTree();
        SaveLoad.Load(familyTree);
        
    }

    

}