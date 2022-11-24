import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Relationship> humans = new ArrayList<>();
    public List<Relationship> getHumans(){
        return humans;
    }

    public void addRelation(Human human1, Human human2, Relations relation1, Relations relation2){
        this.humans.add(new Relationship(human1, human2, relation1));
        this.humans.add(new Relationship(human2, human1, relation2));
    }

    @Override
    public String toString() {
        String res = new String();
        for (Relationship elem : humans) {
            res += elem +"\n";
        }
        return res;
    }
}
