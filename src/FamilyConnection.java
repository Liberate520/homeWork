public class FamilyConnection {
    private Person person;
    private FamilyConnectionType connectionType;

    FamilyConnection(Person person, FamilyConnectionType connectionType) {
        this.person = person;
        this.connectionType = connectionType;
    }

    public Person getPerson() {
        return person;
    }

    public FamilyConnectionType getConnectionType() {
        return connectionType;
    }

    @Override
    public String toString() {
        return "person name = " + person.getName() +
                " - connectionType = " + connectionType;
    }
}
