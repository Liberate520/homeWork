import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> familyList;

    public FamilyTree() {
        familyList = new ArrayList<>();
    }

    public void addPerson(Human person) {
        familyList.add(person);
    }

    public void delPerson(Human person) {
        familyList.remove(person);
    }

    public String getInfoPerson(Human person) {
        return person.getNamePerson();
    }

    public String getInfoList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human person : familyList) {
            stringBuilder.append(person.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

        
        
        
    }

    
}
