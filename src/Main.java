import Alive.enums.Gender;
import Alive.Human;
import Graph.Node;
import Service.HumanSerializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<int[]> nums2 = null;
        ArrayList<Human> humanList =new ArrayList<>();
        humanList.add(new Human("1", Gender.male,10, new Date(1000,07,10)));
        humanList.add(new Human("2", Gender.female,10, new Date(1000,07,10)));
        humanList.add(new Human("3", Gender.male,10, new Date(1020,07,10),
                humanList.get(0),humanList.get(1)));

        humanList.add(new Human("4", Gender.male,10, new Date(1020,07,10),
                humanList.get(2)));
        humanList.add(new Human("5", Gender.male,10, new Date(1020,07,10),
                humanList.get(3)));
        humanList.add(new Human("6", Gender.male,10, new Date(1020,07,10),
                humanList.get(4)));
        humanList.add(new Human("7", Gender.male,10, new Date(1020,07,10),
                humanList.get(5)));
        humanList.add(new Human("8", Gender.male,10, new Date(1020,07,10),
                humanList.get(6)));
        humanList.add(new Human("9", Gender.male,10, new Date(1020,07,10),
                humanList.get(7)));
        humanList.add(new Human("10", Gender.male,10, new Date(1020,07,10),
                humanList.get(8)));
        humanList.add(new Human("11", Gender.male,10, new Date(1020,07,10),
                humanList.get(9)));


        HumanSerializer humanSerializer = new HumanSerializer();
        humanSerializer.humanWriter(new Human("10", Gender.male,10, new Date(1020,07,10)));
        Human human = humanSerializer.humanReader();
        humanSerializer.humanListWriter(humanList);
        List<Human> humans = humanSerializer.humanListReader();
        System.out.println(human);
        FamilyTree familyTree = new FamilyTree(humans);
        List<LinkedHashSet<Node>> paths = familyTree.graphHumanService.graph.getPathAllWrap(
                familyTree.graphHumanService.graph.getNode(1),
                familyTree.graphHumanService.graph.getNode(9));
        for (LinkedHashSet<Node> path: paths) {
            for (Node node: path
                 ) {

//                System.out.print(node.getId()+"-->");
                System.out.print(node+"-->");

            }

        }



    }
}





































