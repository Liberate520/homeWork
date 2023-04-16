import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public Human getMother(Human human){
        return human.getMother();
    }

    public Human getFather(Human human){
        return human.getFather();
    }

    public List<Human> getBrothers(Human human, List<Human> people){
        List<Human> brothers = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
             ) {
            if (item != human && item.getMother() == mother && item.getFather() == father && item.getGender() == Gender.Male){
                brothers.add(item);
            }
        }
        return brothers;
    }

    public List<Human> getSisters(Human human, List<Human> people){
        List<Human> sisters = new ArrayList<>();
        Human mother = human.getMother();
        Human father = human.getFather();
        for (Human item: people
        ) {
            if (item != human && item.getMother() == mother && item.getFather() == father && item.getGender() == Gender.Female){
                sisters.add(item);
            }
        }
        return sisters;
    }

}
