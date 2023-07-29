import Alive.Human;
import Service.GraphHumanService;

import java.util.List;

public class FamilyTree    {

    public GraphHumanService graphHumanService;

    FamilyTree(List<Human> humanList){
        graphHumanService = new GraphHumanService(humanList);
    }
    FamilyTree(){

    }
    boolean addHuman(Human human){
        return graphHumanService.addHuman(human);

    }




}
