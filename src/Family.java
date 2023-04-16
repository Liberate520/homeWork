import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family implements Tree, Serializable{
    List <Human> family = new ArrayList<>();
    @Override
    public void addMember(Human human) {
        family.add(human);
    }

    @Override
    public List<Human> getPeopleList() {
        return family;
    }

    @Override
    public List<Human> getChildren(Human human) {
        return new ArrayList<>(human.getChildren());
    }

    @Override
    public List<Human> getParents(Human human) {
        return new ArrayList<>(human.getParents());
    }

    @Override
    public List<Human> getDescendants(Human Human) {
        List<Human> descendants = new ArrayList<>();
        for (Human child : Human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    @Override
    public List<Human> getAncestors(Human Human) {
        return new ArrayList<>(Human.getParents());
    }

    @Override
    public List<Human> getRelatives(Human Human) {
        List<Human> relatives = new ArrayList<>();
        relatives.addAll(getAncestors(Human));
        relatives.addAll(getDescendants(Human));
        return relatives;
    }

    @Override
    public List<Human> searchByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human Human : family) {
            if (Human.toString().contains(name)) {
                result.add(Human);
            }
        }
        return result;
    }

    @Override
    public void setMarriage(Human human, Human human2) {
        human.setIn_marriage_with(human2);
        human2.setIn_marriage_with(human);
    }

    @Override
    public void setChildren(Human human, Human child) {
        this.addMember(child);
        human.setChildren(child);
        (human.getIn_marriage_with()).setChildren(child);
        child.setParents(human);
        child.setParents(human.getIn_marriage_with());
    }

    @Override
    public void save(Writable writable) throws IOException {
        writable.save((Serializable) this);
    }

    @Override
    public void getInfo() {
        for (Human human : family) {
            System.out.println(human);
        }
    }
}
