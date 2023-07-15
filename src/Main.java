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

        List<Human> humanList = Arrays.asList(human1, human2, human3, human4, human5, human6, human7, human8);

        FamilyTree familyTree = new FamilyTree(humanList);







        familyTree.addNode(new Node(human1));
        familyTree.buildTree();

//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
////        for (Integer id: familyTree.graph.keySet()) {
////            String key = id.toString();
////            String value = familyTree.graph.get(id).getName();
////            System.out.println(key + " " + value);
////
////        }
//
//        familyTree.getAllTree(human1, human2, new LinkedHashSet<>(), familyTree.getPathAllWrap(human1, human2));
    }
}





































