import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Family {
    List<Human> members;

    public Family(List<Human> members) {
        this.members = members;
    }

    public Family(){
        this(new ArrayList<>());
    }

    public void add(Human member) {
        if(member != null) {
            members.add(member);
        }
    }

    public Human search(String sName) {
        Human find = null;
        for (Human human: members) {
            if (human.getName().contains(sName)) {
                find = human;
            }
        }
        return find;
    }

    public List<String> getBroAndSis(String sName) {
        List<String> allNames = new ArrayList<>();
        Human find = search(sName);
        if(find.getFather() != null && find.getFather().getChildren() != null) {
            for (Human child: find.getFather().getChildren()) {
                allNames.add(child.getName());
            }
        }
        if(find.getMother() != null && find.getMother().getChildren() != null) {
            for (Human child: find.getMother().getChildren()) {
                allNames.add(child.getName());
            }
        }
        Set<String> uniq_name = new HashSet<>(allNames); //удалние повторяющихся имен (дети матери и дети отца)
        List<String> res = new ArrayList<>(uniq_name);
        res.remove(sName);
        if(res.isEmpty()) {
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
