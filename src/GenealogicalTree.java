import java.util.ArrayList;
import java.util.List;

public class GenealogicalTree {

    private List<Human> humanList;

    public GenealogicalTree() {
        this.humanList = new ArrayList<>();
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
}

