import Alive.enums.Gender;
import Alive.Human.Human;
import FamilyTree.FamilyTree;
import Graph.Node;
import Service.HumanSerializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<int[]> nums2 = null;
        ArrayList<Human> humanList =new ArrayList<>();
        humanList.add(new Human("Александр", Gender.male,10, new Date(1000,07,10)));
        humanList.add(new Human("Алешка", Gender.female,10, new Date(1000,07,10)));
        humanList.add(new Human("Алексей", Gender.male,10, new Date(1020,07,10),
                humanList.get(0),humanList.get(1)));

        humanList.add(new Human("Михаил", Gender.male,10, new Date(1020,07,10),
                humanList.get(2)));
        humanList.add(new Human("Зина", Gender.male,10, new Date(1020,07,10),
                humanList.get(3)));
        humanList.add(new Human("Леша", Gender.male,10, new Date(1020,07,10),
                humanList.get(4)));
        humanList.add(new Human("Пятая", Gender.male,10, new Date(1020,07,10),
                humanList.get(5)));
        humanList.add(new Human("Шесть", Gender.male,10, new Date(1020,07,10),
                humanList.get(6)));
        humanList.add(new Human("0", Gender.male,10, new Date(1020,07,10),
                humanList.get(7)));
        humanList.add(new Human("10", Gender.male,10, new Date(1020,07,10),
                humanList.get(8)));
        humanList.add(new Human("А", Gender.male,10, new Date(1020,07,10),
                humanList.get(9)));


        HumanSerializer humanSerializer = new HumanSerializer();
        humanSerializer.humanWriter(new Human("10", Gender.male,10, new Date(1020,07,10)));
        Human human = humanSerializer.humanReader();
        humanSerializer.humanListWriter(humanList);
        List<Human> humans = humanSerializer.humanListReader();
//        System.out.println(human);

        FamilyTree familyTree = new FamilyTree(humans);
        for (Node hum : familyTree
                ) {
            System.out.println("Id "+hum.getHuman().getId()+", Name "+hum.getHuman().getName());

        }
        familyTree.sortByName();

        System.out.println(familyTree.getHumanList());
//        List<LinkedHashSet<Node>> paths = familyTree.getGraph().getPathAllWrap(
//                familyTree.getGraph().getNode(1),
//                familyTree.getGraph().getNode(9));
//        for (LinkedHashSet<Node> path: paths) {
//            for (Node node: path
//                 ) {
//
////                System.out.print(node.getId()+"-->");
//                System.out.print(node+"-->");
//
//            }
//
//        }



    }
}





































