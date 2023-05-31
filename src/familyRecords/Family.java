package familyRecords;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Family implements Serializable {
    private final String familyName;
    private Set<Human> members;

    public Family(String name) {
        this.familyName = name;
        members = new HashSet<>();
    }

    public void addHuman(Human human) {
        members.add(human);
    }
    public Set<Human> getMembers() {
        return members;
    }

    public String getName() {
        return familyName;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                '}';
    }
}
