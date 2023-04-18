import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void addMember(Human human) {
        familyMembers.add(human);
    }

    public void showAllMembers() {
        System.out.println(familyMembers);
    }
    
    public Human getInfoByName(String name) {
        for(Human human : familyMembers) {
            if(human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
}
