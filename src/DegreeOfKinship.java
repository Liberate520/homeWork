public class DegreeOfKinship   {
    Human person;
    TypeOfRelationship type;

    public DegreeOfKinship(Human person, TypeOfRelationship type) {
        this.person = person;
        this.type = type;
    }

    public Human getPerson() {
        return person;
    }

    public TypeOfRelationship getType() {
        return type;
    }


}
