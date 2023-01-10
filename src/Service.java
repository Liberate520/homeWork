import java.util.Collections;

public class Service {
    private Family family;

    public Service(Family family) {
        this.family = family;
    }

    public void sortByName() {
        Collections.sort(family.getMembers());
    }

    public void sortByYearBirth() {
        Collections.sort(family.getMembers(), new HumanComparatorYearBirth());
    }

}
