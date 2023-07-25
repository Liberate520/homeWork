import human.Human;
import human.Writable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenealogicalTree implements Serializable {

    private List<Human> humanList;

    public GenealogicalTree() {
        this.humanList = new ArrayList<>();
    }

    public GenealogicalTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(Human human){
        if(!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    public void showAllHumans(){
        for (Human human: this.humanList
        ) {
            System.out.println(human);
        }
    }

    public List<Human> getHumanByLastName(String lastName) {
        List<Human> result = new ArrayList<>();
        for (Human human:humanList
        ) {
            String lastNameHuman = getLastName(human);
            if(lastNameHuman.equalsIgnoreCase(lastName)) result.add(human);
        }
        return result;
    }

    private String getLastName(Human human) {
        return human.getLastName(human);
    }

    public List<Human> getHumanByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human:humanList
        ) {
            String nameHuman = getName(human);
            if(nameHuman.equalsIgnoreCase(name)) result.add(human);
        }
        return result;
    }

    private String getName(Human human) {
        return human.getName(human);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human: humanList
        ) {
            sb.append(human.toString());
            sb.append("--------------------");
            sb.append("\n");
        }
        return sb.toString();
    }
}

