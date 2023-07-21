import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends HumanItem> implements Serializable, Iterable<T> {
    private List<T> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void addMember(T human) {
        familyMembers.add(human);
    }

    public void showAllMembers() {
        System.out.println(familyMembers);
    }

    public String toString() {
        for(T human : familyMembers) {
            human.getName();
        }
        return "Члены семьи: " + familyMembers;
    }
    
    public T getInfoByName(String name) {
        for(T human : familyMembers) {
            if(human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyIterator(familyMembers);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for(T human : familyMembers) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    public void sortByName() {
        Collections.sort(familyMembers, new HumanComporatorByName<>());
    }

    public void sortByAge() {
        Collections.sort(familyMembers, new HumanComporator());
    }
}
