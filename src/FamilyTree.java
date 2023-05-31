import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human getByName(String name){
        for(Human item : humanList){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public List<Human> findBrothers1(Human humanForSearch){
        List<Human> brothersList = new ArrayList<>();

        for(Human item : humanList){
            if(item.getFather() != null) {
                if (item.getFather().equals(humanForSearch.getFather())
                        && item.getGender() == Gender.MALE
                        && !item.getName().equals(humanForSearch.getName())) {
                    brothersList.add(item);
                }
            }
        }
        return brothersList;
    }

    public List<Human> findBrothers(Human humanForSearch){
        List<Human> brothersList = new ArrayList<>();
        List<Human> tempList = new ArrayList<>();
        if(humanForSearch.getFather() != null) {tempList = humanForSearch.getFather().getChildren();}
        else if (humanForSearch.getMother() != null) {tempList = humanForSearch.getMother().getChildren();}

        for(Human item : tempList){
            if (item.getGender() == Gender.MALE && !item.getName().equals(humanForSearch.getName())){
                brothersList.add(item);
            }
        }

        return brothersList;
    }

    public String printHumanList(){
        String printer = "Family tree contains " + humanList.size() + " entities:" + "\n";
        for(Human item : humanList){
            printer += item.toString() + "\n";
        }
        return printer;
    }

}
