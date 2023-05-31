import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humanList;

    public Tree() {
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

    public Human findHumanName(String name) {
        for (Human human: humanList) {
            if (human.getName().equalsIgnoreCase(name)){
                return human;
            }
        }
        return null;
    }

    public Human findHumanDate(String date) {
        for (Human human: humanList) {
            if (human.getDate().equalsIgnoreCase(date)){
                return human;
            }
        }
        return null;
    }

    public String getHumanList() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}


