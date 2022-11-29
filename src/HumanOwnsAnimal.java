import java.util.ArrayList;
import java.util.List;

public class HumanOwnsAnimal {
    private List<RelationWithAnimal> humanOwn = new ArrayList<>();

    public List<RelationWithAnimal> getHumanOwn() {
        return humanOwn;
    }

    public void setHumanOwn(List<RelationWithAnimal> humanOwn) {
        this.humanOwn = humanOwn;
    }

    public void addAnimal(Human h1, Animal a1, RelationAnimal r1) {
        this.humanOwn.add(new RelationWithAnimal(h1, a1, r1));
    }

    public void addHuman(Animal a1, Human h1, RelationAnimal r1) {
        this.humanOwn.add(new RelationWithAnimal(h1, a1, r1));
    }



    @Override
    public String toString() {
        String result = new String();
        for (RelationWithAnimal elem : humanOwn) {
            result += elem +"\n";
        }
        return result;
    }
}
