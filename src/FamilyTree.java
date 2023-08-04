import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    List<Human> familyList = new ArrayList<>();

    public void familyAdd(Human name){
        familyList.add(name);
    }

    public void familyInfo(){
        System.out.println(familyList + "\n");
    }
}
