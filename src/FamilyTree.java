import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        for(Human human: humanList){
            if(human.equals(human)){
                System.out.println("Такой человек уже есть в семейном древе");
            } else {
                humanList.add(human);
            }
        }
    }

    public Human findHumanByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getHumanList(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
