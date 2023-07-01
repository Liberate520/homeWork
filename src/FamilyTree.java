import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family = new ArrayList<>();
    public void addHuman(Human h){ family.add(h); }

    @Override
    public String toString() {
        List<String> familyMembers = new ArrayList<>();
        for (Human h : family)
            familyMembers.add(h.toString());
        return String.join(",", familyMembers);
    }
}
