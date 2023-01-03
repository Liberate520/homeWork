import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Family {

    List<People> members;

    public Family(List<People> members) {
        this.members = members;
    }

    public Family() {
        this(new ArrayList<>());
    }

    public void add(People member) {
        if (member != null) {
            members.add(member);
        }
    }

    public People search(String sPeopleName) {
        People finderPeople = null;
        for (People people : members) {
            if (people.getName().contains(sPeopleName)) {
                finderPeople = people;
            }
        }
        return finderPeople;
    }

    public List<String> getFamMembers(String sPeopleName) {
        List<String> allNames = new ArrayList<>();
        People finderPeople = search(sPeopleName);
        if (finderPeople.getFather() != null && finderPeople.getFather().getChildren() != null) {
            for (People child : finderPeople.getFather().getChildren()) {
                allNames.add(child.getName());
            }
        }
        if (finderPeople.getMother() != null && finderPeople.getMother().getChildren() != null) {
            for (People child : finderPeople.getMother().getChildren()) {
                allNames.add(child.getName());
            }
        }
        Set<String> uniq_name = new HashSet<>(allNames); // удалние повторяющихся имен (дети матери и дети отца)
        List<String> res = new ArrayList<>(uniq_name);
        res.remove(sPeopleName);
        if (res.isEmpty()) {
            res.add("нет братьев или сестер");
        }
        return res;
    }

    @Override
    public String toString() {
        return "Family: " +
                members;
    }
}
