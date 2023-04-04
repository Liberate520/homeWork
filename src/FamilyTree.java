import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> humanList;
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве содержится ");
        sb.append(humanList.size());
        sb.append(" записей \n");
        for (Human human: humanList){
            sb.append(human.getInfoHuman());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Human getBySurname(String surname){
        for (Human human : humanList){
            if (human.getSurname().equals(surname)){
                return human;
            }
        }
        return null;
    }
    public Human getByID(int id){
        for (Human human : humanList){
            if (human.getHumanID() == (id)){
                return human;
            }
        }
        return null;
    }
}
