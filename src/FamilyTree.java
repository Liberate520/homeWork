import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        this.humans.add(human);
    }

    public List<Human> getAllHumans(){
        return this.humans;
    }

    public void isParent(){

    }



}
