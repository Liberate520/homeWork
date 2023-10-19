import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTreeList = new ArrayList<>();

    public void addHuman(Human human){
        familyTreeList.add(human);
    }

    public void getAllHuman(){
        for (Human human: familyTreeList){
            System.out.println(human.allInfo());
        }
    }

    public void getHuman(int id){
        for (Human human: familyTreeList){
            if(human.id == id){
                System.out.println(human.allInfo());
            }
        }
    }
}
