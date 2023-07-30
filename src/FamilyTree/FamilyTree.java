package FamilyTree;

import Alive.Human.Comparators.*;
import Alive.Human.Human;
import Graph.Graph;
import Graph.Node;
import Service.FamilyTreeIterator;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Node>{
    private Graph graph;
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList){
        this.graph=new Graph(humanList);
        this.humanList=humanList;
    }

    public boolean sortByName(){
        humanList.sort(new HumanComparatorByName());
        return true;
    }
    public boolean sortByAge(){
        humanList.sort(new HumanComparatorByAge());
        return true;
    }
    public boolean sortByDataDie(){
        humanList.sort(new HumanComparatorByDataDie());
        return true;
    }
    public boolean sortByDataBorn(){
        humanList.sort(new HumanComparatorByDataBorn());
        return true;
    }
    public boolean sortById(){
        humanList.sort(new HumanComparatorById());
        return true;
    }
    public boolean sortByQuantityChildren(){
        humanList.sort(new HumanComparatorByQuantityChildren());
        return true;
    }

    public Graph getGraph(){
        return graph;
    }
    public List<Human> getHumanList(){
        return humanList;
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
        graph.clearGraph();
        this.graph=new Graph(humanList);
        return true;
    }



    @Override
    public Iterator<Node> iterator() {
        return new FamilyTreeIterator(graph, graph.getNode(1));
    }


}
