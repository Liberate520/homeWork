package Service;

import Alive.Human;
import Graph.Graph;

import java.util.Collections;
import java.util.List;

public class GraphHumanService {

    public Graph graph;
    private List<Human> humanList;

    private FamilyTreeDataService familyTreeDataService;

    public GraphHumanService(List<Human> humanList){
        this.humanList = humanList;
        this.familyTreeDataService = new FamilyTreeDataService(humanList);
        this.graph = new Graph(familyTreeDataService.graphData);

    }

    Human getHumanByID(int id){
        for (Human hum : humanList) {
            if (hum.getId() == id)
                return hum;

        }
        return null;
    }
    List<Human> getHumanChildren(int id){
       return Collections.singletonList((Human) getHumanByID(id).getChildren());
    }
    public boolean addHuman(Human human){
        humanList.add(human);
       return true;
    }

}
