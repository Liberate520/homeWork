import family.FamilyTree;
import human.Human;
import human.comparators.HumanComparatorByIdASC;
import human.comparators.HumanComparatorByIdDESC;
import human.comparators.HumanComparatorByNameASC;
import human.comparators.HumanComparatorByNameDESC;

import java.util.Date;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree family;

    public Service(FamilyTree family) {
        this.family = family;
    }

    public void addPerson(String humanName, String humanSurname, Date dateOfBirth, Date dateOfDeath,
                          Integer motherID, Integer fatherID, Integer partnerID) {

        Human human = new Human(id, humanName, humanSurname, dateOfBirth, dateOfDeath, motherID, fatherID, partnerID);
        family.add(id, human);
        id++;
    }

    public List<Human> getSortedListByIdDESC() {
        List<Human> result = family.getHumanList();
        result.sort(new HumanComparatorByIdDESC());
        return result;
    }

    public List<Human> getSortedListByIdASC() {
        List<Human> result = family.getHumanList();
        result.sort(new HumanComparatorByIdASC());
        return result;
    }

    public List<Human> getSortedListByNameASC() {
        List<Human> result = family.getHumanList();
        result.sort(new HumanComparatorByNameASC());
        return result;
    }

    public List<Human> getSortedListByNameDESC() {
        List<Human> result = family.getHumanList();
        result.sort(new HumanComparatorByNameDESC());
        return result;
    }
}
