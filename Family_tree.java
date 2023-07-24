package homeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_tree implements Serializable {
    List<Human> list = new ArrayList<>();
    public void addHuman(Human human){list.add(human);}

/*    public void setChildrenToParents(Human child, Human parent1, Human parent2) {
        if((child.getFather().equals(parent1) || child.getFather().equals(parent2)) ||
                (child.getMother().equals(parent1) || child.getMother().equals(parent2))){
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
    }*/

    public void setParentsAndChilds(Human child, Human parent1, Human parent2) {
        if(child.getFather() == null && parent1.getGender().equals(Gender.Male)){
            child.setFather(parent1);
            child.setMother(parent2);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        } else if (child.getFather() == null && parent2.getGender().equals(Gender.Male)) {
            child.setFather(parent2);
            child.setMother(parent1);
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
        else if((child.getFather().equals(parent1) || child.getFather().equals(parent2)) ||
                (child.getMother().equals(parent1) || child.getMother().equals(parent2))){
            parent1.getChildren().add(child);
            parent2.getChildren().add(child);
        }
    }
    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дерево:\n");
        for (Human human: list){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
