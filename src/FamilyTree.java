import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> people = new ArrayList<>();

    public void addHuman(Human human){
        people.add(human);
    }
    public Human getHuman(String firstName, String lastName, String birthday){
        for (Human human: people
        ) {
            if (human.getFirstName().equals(firstName) && human.getLastName().equals(lastName) && human.getBirthday().equals(birthday)){
                return human;
            }
        }
        return null;
    }

    public Human getMother(Human human){
        return human.getMother();
    }

    public Human getFather(Human human){
        return human.getFather();
    }

    public List<Human> getBrothers(Human human){
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

    public List<Human> getSisters(Human human){
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
    public List<Human> getAllHuman(){
        return people;
    }
}
