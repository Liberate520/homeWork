import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public List<Human> findBrothers(Human humanForSearch){
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

    public void printHumanList(){
        for(Human item : humanList){
            System.out.println(item.toString());
        }
    }


}
