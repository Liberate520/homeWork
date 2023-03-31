package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    String name;
    List<Human> familyList = new ArrayList<>();

    public FamilyTree(String name){
        this.name = name;
    }
    public void addHuman(Human human){
        familyList.add(human);
    }
    public void getAllChild(Human human){
        for (Human kid: familyList.get(familyList.indexOf(human)).childList ) {
            System.out.println(kid.info());
        }
    }
}
