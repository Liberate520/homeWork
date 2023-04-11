

import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

public class Tree implements Serializable {
    private Set<Human> relatives;

    public Tree() {
        relatives = new HashSet<>();
    }

    public Tree(Set<Human> people) {
        this.relatives = people;
    }

    public void add(Human human) {
        relatives.add(human);
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getWifeOrHusband() != null) {
            human.getWifeOrHusband().setWifeOrHusband(human);
        }
    }

    public Human getByName(String name) {
        String[] tempString = name.split(" ");
        for (Human human : relatives) {
            if (human.getSecondName() == tempString[0]
                    && human.getFirstName() == tempString[1]
                    && human.getPatronymic() == tempString[2]) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("в дереве: ");
        sb.append(relatives.size());
        sb.append(" объектов: \n");
        int count=1;
        for (Human human : relatives) {
            sb.append(count + ". ");
            sb.append(human.getInfo());
            sb.append(" \n");
            count++;
        }
        return sb.toString();
    }

}
