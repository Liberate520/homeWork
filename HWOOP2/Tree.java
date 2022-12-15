import java.util.ArrayList;
import java.util.List;

public abstract class Tree implements Doable{
    private Human Human1;
    private List<Relationship> humansRelationships = new ArrayList<>();
    private List<Human> humans = new ArrayList<>();
    public List<Relationship> getHumans(){
        return humansRelationships;
    }

    public Human getHuman() {
        return Human1;
    }

    @Override
    public void addRelation(Human human1, Human human2, Relations relation1, Relations relation2){
        this.humansRelationships.add(new Relationship(human1, human2, relation1));
        this.humansRelationships.add(new Relationship(human2, human1, relation2));
    }

    public void addPerson(Human human1) {
        this.humans.add(human1);
    }

    @Override
    public String toString() {
        String res = new String();
        for (Relationship elem : humansRelationships) {
            res += elem +"\n";
        }
        return res;
    }

    @Override
    public String print(){
        String res = new String();
        for (Human human : humans) {
            res += human +"\n";
        }
        return res;
    }
    @Override
    public void search(String name) {
        for (Human human : humans) {
            if (human.getFirstName().equals(name)) {
                System.out.println("The result of the search is: " + human);
            }
            else {
                System.out.println("There is no such person in the Family Tree!");
                break;
            }
        }
    }
}
