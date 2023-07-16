import javax.lang.model.type.NullType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human  human1 = new Human("Dima", Gender.Male, LocalDate.of(1900,01,12));
        Human  human2 = new Human( "Misha", Gender.Male, LocalDate.of(1920,01,20));
        Human  human3 = new Human( "Misha1", Gender.Male, LocalDate.of(1920,01,20));
        Human  human4 = new Human( "Misha2", Gender.Male, LocalDate.of(1920,01,20));
        Human  human5 = new Human( "Misha3", Gender.Male, LocalDate.of(1920,01,20));
        Human  human6 = new Human( "Misha4", Gender.Male, LocalDate.of(1920,01,20));
        Human  human7 = new Human( "Misha5", Gender.Male, LocalDate.of(1920,01,20));
        Human  human8 = new Human( "Misha6", Gender.Male, LocalDate.of(1920,01,20));

        human1.AddChildren(human2);
        human2.AddChildren(human3);
        human3.AddChildren(human4);
        human4.AddChildren(human5);
        human4.AddChildren(human6);
        human6.AddChildren(human7);
        human6.AddChildren(human8);

        ArrayList<Human> humanList = new ArrayList();
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
        humanList.add(human4);
        humanList.add(human5);
        humanList.add(human6);
        humanList.add(human7);
        humanList.add(human8);


        FamilyTree familyTree = new FamilyTree(humanList);
        familyTree.addNode(new Node(human1));
        familyTree.buildTree();
        FileHandler fileHandler = new FileHandler();
        fileHandler.tryWriteHumanFile(humanList);
        for (Integer item: familyTree
             ) {
            System.out.println(item.toString());

        }
    }
}





































