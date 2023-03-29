import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList){
        this.humanList =humanList;


    }

    public FamilyTree() {
       this(new ArrayList<>());
    }

    public void addHuman(Human human){

        humanList.add(human);
    }



    @Override
    public String toString(){
        return humanList.toString();
    }
}
