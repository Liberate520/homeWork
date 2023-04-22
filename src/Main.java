import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException  {
        FamilyTree familyTree = new FamilyTree();
        WorkingWithFiles workingWithFiles = new FileHandler();

        Human human1 = new Human("Дмитрий", "Бохан", Gender.Male, "12.11.1990");
        Human human2 = new Human("Ирина", "Бохан", Gender.Female, "31.10.1965");
        Human human3 = new Human("Анна", "Новикова", Gender.Female, "23.10.1988");
        Human human4 = new Human("Павлина", "Мищенко", Gender.Female, "13.03.1934");
        familyTree.addHumanOfFamilyTree(human1);
        familyTree.addHumanOfFamilyTree(human2);
        familyTree.addHumanOfFamilyTree(human3);
        familyTree.addHumanOfFamilyTree(human4);
        human4.setDateOfDeath("06.04.2008");
        human2.setMother(human4);
        human1.setMother(human2);
        familyTree.listOfNames();
        System.out.println("----------------------------------------------------------------");
        //human4.getInfo();
        //human2.getInfo();
        familyTree.searchByName("Ирина");

        workingWithFiles.save(familyTree);

        FamilyTree tree = workingWithFiles.write();

        tree.listOfNames();




    }
}
