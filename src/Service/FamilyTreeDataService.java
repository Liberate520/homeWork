package Service;

import Alive.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeDataService {
   public ArrayList<int[]> graphData;
   public List<Human> humanList;



    FamilyTreeDataService(List<Human> humanList){
        this.graphData= generateGraphData(humanList);
        this.humanList=humanList;

    }
    public ArrayList<int[]> generateGraphData(List<Human> humanList){
        ArrayList<int[]> graphData= new ArrayList<int[]>();
        for (Human human : humanList
        ) {
            if (human.getChildren()!=null){
                for (Human child: human.getChildren()
                ) {
                    graphData.add(new int[]{human.getId(), child.getId(), child.born.getYear() - human.born.getYear()});
                }

            }
            else {
                graphData.add(new int[]{human.getId(), 0, 0});
            }

        }
        return graphData;
    }

}
