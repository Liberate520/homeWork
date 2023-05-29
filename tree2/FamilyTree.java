package homeWork.tree2;

import java.io.Serializable;
import java.util.ArrayList;


public class FamilyTree implements Serializable {
    private ArrayList<Human> families;


    public FamilyTree() {
        families = new ArrayList<>();
    }

    public void addPeople(Human person) {
        families.add(person);
    }

    public String getFamilies() {
        StringBuilder sb = new StringBuilder();
        for(Human person : families){
            sb.append(person);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Human findPersonByName(FamilyTree familyTree, String name) {
        for(Human man: families) {
            if(man.getName().equalsIgnoreCase(name)){
                return man;
            }
        }
        return null;
    }


}
