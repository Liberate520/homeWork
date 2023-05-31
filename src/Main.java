import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
        Human human1 = new Human("O-647", LocalDate.of(2078,04,12), Gender.MALE);
        Human human2 = new Human("I-693", LocalDate.of(2079,06,17), Gender.FEMALE);
        Human human3 = new Human("K-953", LocalDate.of(2101,01,04), Gender.MALE, human1, human2);
        Human human4 = new Human("P-328", LocalDate.of(2101,01,04), Gender.FEMALE, human1, human2);
        Human human5 = new Human("L-493", LocalDate.of(2104,07,19), Gender.MALE, human1, human2);
        Human human6 = new Human("M-727", LocalDate.of(2134,11,06), Gender.FEMALE, human4, human5);
        Human human7 = new Human("U-952", LocalDate.of(2134,02,17), Gender.FEMALE, human4, human5);

        human1.addChild(human3);
        human1.addChild(human4);
        human1.addChild(human5);
        human2.addChild(human3);
        human2.addChild(human3);///children doubling check

        human2.addChild(human4);
        human2.addChild(human5);
        human4.addChild(human6);
        human4.addChild(human7);
        human5.addChild(human6);
        human5.addChild(human7);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

        System.out.println(familyTree.printHumanList());

        System.out.println("-------------------");

        List<Human> brothersList1 =  familyTree.findBrothers(human5);
        System.out.println(brothersList1);
        */


        // блок для сохранения
        //Movable movableSaver = new FileHandler();
        //movableSaver.save(familyTree, "familyTreeOne");

        //блок для чтения файла
        Movable movableLoader = new FileHandler();
        FamilyTree familyTreeRestored = (FamilyTree) movableLoader.load("familyTreeOne");
        System.out.println(familyTreeRestored.printHumanList());





    }


}
