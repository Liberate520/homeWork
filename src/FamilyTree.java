import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> people;

    public FamilyTree(List<Human> people) {
        this.people = people;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addpeople(Human h, Human mh, Human fh) {
        if (mh != null)
            mh.addchildren(h);
        if (fh != null)
            fh.addchildren(h);
        people.add(h);
    }

    public Human findHuman(String str, Human nl) {
        for (Human item : people) {
            if (str.toLowerCase().equals(item.getName().toLowerCase())) {
                return item;
            }
        }
        return nl;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.people);
        return str.toString();
    }
}
