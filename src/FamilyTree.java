import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable {
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

    public String toString() {
        for(Human human : familyMembers) {
            human.getName();
        }
        return "Члены семьи: " + familyMembers;
    }
    
    public Human getInfoByName(String name) {
        for(Human human : familyMembers) {
            if(human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
