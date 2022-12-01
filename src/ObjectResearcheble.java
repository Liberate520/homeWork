import java.util.List;

public abstract class ObjectResearcheble implements Comparable<ObjectResearcheble>  {

    public abstract Human getFather();

    public abstract String getName();

    public abstract List<DegreeOfKinship> getRelationShip();


    public abstract int getId();

    public abstract void addRelationShip(Human person_first, Human person_second, TypeOfRelationship typeOfRelationship);

    public abstract TypeOfGender getTypeOfGender();


    public abstract int compareTo(Human person);
}
