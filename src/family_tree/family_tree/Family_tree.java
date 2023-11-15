package family_tree.family_tree;

import family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_tree implements Serializable {
    private ArrayList<Human> family_tree;

    public Family_tree() {
        this.family_tree = new ArrayList<>();
    }

    public  void AddHuman(Human human){
        this.family_tree.add(human);
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо семьи:\n");
        for (Human human: this.family_tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
