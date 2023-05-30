package tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private final List<Human> humanList;


    public FamilyTree() {
        humanList=new ArrayList<>();
    }

    public  void addHuman(Human human){
        humanList.add(human);



    }

        public Human findHumanByName(String name) {
            for (Human human : humanList) {
                if (human.getName().equalsIgnoreCase(name)) {
                    return human;
                }
            }return  null;
        }

    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "humanList=" + humanList +
                '}';
    }
}

