import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Human human1 = new Human("O-647", "12.04.2078", Gender.MALE);
        Human human2 = new Human("I-693", "17.06.2079", Gender.FEMALE);
        Human human3 = new Human("K-953", "04.01.2101", Gender.MALE, human1, human2, new ArrayList<Human>());
        Human human4 = new Human("P-328", "04.01.2101", Gender.FEMALE, human1, human2, new ArrayList<Human>());
        Human human5 = new Human("L-493", "19.07.2104", Gender.MALE, human1, human2, new ArrayList<Human>());
        Human human6 = new Human("M-727", "06.11.2134", Gender.FEMALE, human4, human5, new ArrayList<Human>());
        Human human7 = new Human("U-952", "17.02.2134", Gender.FEMALE, human4, human5, new ArrayList<Human>());

        human1.addChild(human3);
        human1.addChild(human4);
        human1.addChild(human5);
        human2.addChild(human3);
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

        familyTree.printHumanList();

        System.out.println("-------------------");

        List<Human> brothersList1 =  familyTree.findBrothers(human5);
        System.out.println(brothersList1);
    }

}
