import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> family = new ArrayList<>();
    public void addHuman(Human h){ family.add(h); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int cnt=0;
        for (Human h : family){
            result.append(h.toString());
            if(++cnt < family.size()-1) result.append(',');
        }
        return result.toString();
    }
}
