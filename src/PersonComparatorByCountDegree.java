import java.util.Comparator;

public class PersonComparatorByCountDegree implements Comparator<ObjectResearcheble> {



    @Override
    public int compare(ObjectResearcheble o1, ObjectResearcheble o2) {
        return Integer.compare(o1.getRelationShip().size(), o2.getRelationShip().size());
    }
}
