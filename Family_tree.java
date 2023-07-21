package homeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_tree implements Serializable {
    List<Human> list = new ArrayList<>();
    public void addHuman(Human human){list.add(human);}

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
