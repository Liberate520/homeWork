
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;






public class Main 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {   
        FamilyTree familyTree = new FamilyTree();
        
        Human human1= new Human(1, "Иванов","Владмир", Gender.Male, LocalDate.of(1925, 10, 04), LocalDate.of(1987, 04, 01), null, null, null);
        // familyTree.addPerson(human1);
        // System.out.println(Human1 + "\n");

        Human human2= new Human(2, "Петров","Николай", Gender.Male, LocalDate.of(1928, 5, 10), LocalDate.of(1980, 03, 17), null, null,null);     
        // familyTree.addPerson(human2);
        // System.out.println(Human2 + "\n");

        Human human3= new Human(3, "Иванова","Екатерина", Gender.Female, LocalDate.of(1927, 7, 23), LocalDate.of(1984, 10, 2), null, null, null);
        // people.add(human3);
        // System.out.println(Human3 + "\n");

        Human human4= new Human(4, "Петрова", "Антонина", Gender.Female, LocalDate.of(1928,06, 11), LocalDate.of(1990, 01, 20), null,null,null);
        // familyTree.addPerson(human4);
        // System.out.println(Human4 + "\n");

        Human human5= new Human(5, "Михайлов","Роман",Gender.Male, LocalDate.of(1923, 10, 5), LocalDate.of(1990, 2, 4), null,null,null);
        // familyTree.addPerson(human5);
        // System.out.println(Human5 + "\n");

        Human human6= new Human(6,"Михайлова","Екатерина",Gender.Female, LocalDate.of(1925, 5, 8), LocalDate.of(1993, 10, 4), null,null, null);
        // familyTree.addPerson(human6);
        // System.out.println(Human6 + "\n");

        Human human7= new Human(7,"Матвеев","Антон",Gender.Male, LocalDate.of(1923, 5, 17), LocalDate.of(1995, 10, 9),null,null,null);
        // familyTree.addPerson(human7);
        // System.out.println(Human7 + "\n");

        Human human8= new Human(8,"Матвеева","Екатерина",Gender.Female,LocalDate.of(1928, 9, 28),LocalDate.of(1995, 03, 25),null,null, null);
        // familyTree.addPerson(human8);
        // System.out.println(Human8 + "\n");
            
        Human human9 = new Human(9,"Иванов","Иван",Gender.Male,LocalDate.of(1950, 3, 25),null, human1,human3,null);
        // familyTree.addPerson(human9);
        // System.out.println(Human9 + "\n");

        Human human10 = new Human(10,"Петров", "Пётр",Gender.Male,LocalDate.of(1948, 11, 11), null, human2,human4,null);
        // familyTree.addPerson(human10);
        // System.out.println(human10 + "\n");

        Human human11 = new Human(11,"Михайлова","Мария",Gender.Female,LocalDate.of(1953, 12, 30), null, human5,human6,null);
        // familyTree.addPerson(human11);
        // System.out.println(human11 + "\n");

        Human human12 = new Human(12,"Матвеева","Елена",Gender.Female,LocalDate.of(1950, 9, 28), null,human7,human8,null);
        // familyTree.addPerson(human12);
        // System.out.println(human12 + "\n");

        Human human13 = new Human(13,"Иванов","Антон",Gender.Male,LocalDate.of(1980, 5, 28) , null,human9,human11,null);
        // familyTree.addPerson(human13);
        // System.out.println(human13 + "\n"); 

        Human human14 = new Human(14,"Петров","Кирилл",Gender.Male,LocalDate.of(1983, 11, 20),null, human10,human12,null);
        // familyTree.addPerson(human14);
        // System.out.println(human14 + "\n");

        //  System.out.println(familyTree); // печать дерева без цикла!!!

        
        // familyTree.findHuman();  // поиск людей!
        
    
            // ObjectWrite.Writer(familyTree);
            // ObjectRead.Reader();
            // WriteText.SaveTxt(familyTree);
            // ReadText.ReadTxt();
            // WriteDoc.SaveDoc(familyTree);
            // ReadDoc.Doc();
            // WriteMD.SaveMD(familyTree);
            // ReadMD.ReadMD();
        
            // FileHandlerSave fhs = new FileHandlerSave();
            // fhs.SaveFormat(familyTree);

        List<Human> human = new ArrayList<>(Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8, human9, human10, human11, human12, human13, human14));

        for (Human value : human) 
        {
            familyTree.addPerson(value); // добавляем людей в цикле
        }
        System.out.println("Печать дерева после цикла: \n" + familyTree); // печать дерева после добавления людей через цикл!

        familyTree.sortByAge();
        System.out.println("Список, отсортированный по возрасту: " + familyTree);
        
        familyTree.sortByLastName();
        System.out.println("Список, отсортированный по имени: " + familyTree);
        
    }
}


