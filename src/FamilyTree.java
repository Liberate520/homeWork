import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyList = new ArrayList<>();

    public void familyAdd(Human name){
        familyList.add(name);
    }

    public void setFamilyList(List<Human> familyList) {
        this.familyList = familyList;
    }

    public List<Human> getFamilyList() {
        return familyList;
    }

    public void familyInfo(){
        System.out.println(familyList + "\n");
    }
}
