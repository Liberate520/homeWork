package familyRecords;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Family implements Serializable {
    private final String familyName;
    private List<Human> members;

    public Family(String name) {
        this.familyName = name;
        members = new ArrayList<>();
    }

    private boolean humanInMembers(Human humanToCheck) {
        for (Human human : members) {
            if (humanToCheck.equals(human)) return true;
        }
        return false;
    }

    public void addHuman(Human human) {
        if (!humanInMembers(human)) members.add(human);
    }
    public List<Human> getMembers() {
        return members;
    }

    public String getName() {
        return familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(familyName, family.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName);
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyName='" + familyName + '\'' +
                ", members=" + members +
                '}';
    }
}
