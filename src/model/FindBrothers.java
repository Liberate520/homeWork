package model;

import java.util.ArrayList;
import java.util.List;

public class FindBrothers{
    public List<Human> find(Human humanForSearch){
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
}
