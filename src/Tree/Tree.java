package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humanList;

    public Tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public Human getByName(String name) {
        for (Human x : humanList) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    public void add(Human human) {
        humanList.add(human);
    }

    @Override
    public String toString() {
        return "Генеакологическое древо{\n" +
                "humanList=" + humanList +
                '}'+" \n";
    }
}
