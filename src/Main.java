import java.time.LocalDate;
import fileWork.FilehandlerOS;
import fileWork.Writeable;
import group.FamilyTree;
import group.Groupable;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
            Groupable familyTree = new FamilyTree();

            familyTree.addHuman(new Human(1, "Романов Михаил", LocalDate.of( 1596, 7, 22),
                LocalDate.of(1645, 7, 23),
                Gender.male, null, null, null));

            familyTree.addHuman(new Human(2, "Нарышкина Наталья", LocalDate.of(1629, 3, 19),
            null, Gender.female, familyTree.getHumanByName("Стрешнева Евдокия"), null,
            null));

            familyTree.addHuman(new Human(3, "Салтыкова Прасковья", LocalDate.of(1957, 8, 02),
            null, Gender.female, null, null,
            null));

            familyTree.addHuman(new Human(4, "Евдокия Лопухина", LocalDate.of(1979, 9, 14), 
            null, Gender.female, familyTree.getHumanByName("Стрешнева Евдокия"), familyTree.getHumanByName("Салтыкова Прасковья"), 
            null));

            familyTree.addHuman(new Human(5, "Милославская Мария", LocalDate.of(1987, 04, 02), 
            null, Gender.female, familyTree.getHumanByName("Романов Михаил"),null,
            null));
            
            familyTree.addHuman(new Human(6, "Романов Алексей", LocalDate.of(2010, 8, 11), 
            null,Gender.male, familyTree.getHumanByName("Евдокия Лопухина"), null, 
            null));

            familyTree.addHuman(new Human(7, "Романов Иоанн", LocalDate.of(2013, 7, 28), 
            null, Gender.male, familyTree.getHumanByName("Евдокия Лопухина"), null, 
            null));

            String filenameOS = "FamilyTree.dat";

            Writeable fileOS = new FilehandlerOS();

            fileOS.saveToFile(familyTree, filenameOS);

            familyTree = fileOS.loadFromFile(filenameOS);

            for (Human human : familyTree.getHumanList()) {
                System.out.print(human);
            }
    }
}
