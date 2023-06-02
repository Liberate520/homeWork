package three;

import java.util.ArrayList;
import java.util.List;

public class FamilyThree {
    
    int id_forChild = 0;
    private List <Human> children;
    private List <Human> familyList;
    private List <Human> BroSisList;



    public FamilyThree(){
        familyList = new ArrayList<>();
        children = new ArrayList<>();
        BroSisList = new ArrayList<>();

    }
    public void addFamily(Human human){
        if (familyList.size() < 10){
            familyList.add(human);
        }
    }
    public void addChildren(Human human){
        if (children.contains(id_forChild < 2)){
            children.add(human);
        }

    }
    public Human findHumanName(String name){
        for (Human human: familyList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public List<Human> findHumanSisterBrother(int id){
        for (Human human: familyList)
            if (human.getId() == id) {
                BroSisList.add(human);
            }
        return BroSisList;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getFamilyList() {
        return familyList;
    }

    public List<Human> getBroSisList() {
        return BroSisList;
    }
}