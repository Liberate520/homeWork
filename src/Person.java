import java.util.ArrayList;
import java.util.List;

public class Person {
    private PersonGender gender;
    private String name;
    private List<FamilyConnection> connectionList;

    Person(String name, PersonGender gender, List<FamilyConnection> connectionList) {
        this.name = name;
        this.gender = gender;
        this.connectionList = connectionList;
    }
    Person(String name, PersonGender gender) {
        this(name, gender, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonGender getGender() {
        return gender;
    }

    public List<FamilyConnection> getConnectionList() {
        return connectionList;
    }

    public void addConnection(Person person, FamilyConnectionType connectionType) {
        if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                &&  this.gender == PersonGender.male) {
            person.connectionList.add(new FamilyConnection(this, FamilyConnectionType.father));
        } else if ((connectionType == FamilyConnectionType.son || connectionType == FamilyConnectionType.daughter)
                && this.gender == PersonGender.female) {
            person.connectionList.add(new FamilyConnection(this, FamilyConnectionType.mother));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && this.gender == PersonGender.male) {
            person.connectionList.add(new FamilyConnection(this, FamilyConnectionType.son));
        } else if ((connectionType == FamilyConnectionType.father || connectionType == FamilyConnectionType.mother)
                && this.gender == PersonGender.female) {
            person.connectionList.add(new FamilyConnection(this, FamilyConnectionType.daughter));
        }
        connectionList.add(new FamilyConnection(person, connectionType));
    }

    public void showConnection(FamilyConnectionType connectionType){
        for (var connection : connectionList) {
            if (connection.getConnectionType() == connectionType) System.out.println(connection.getPerson());
        }
    }

    @Override
    public String toString() {
        return "gender = " + gender +
                ", name = '" + name + '\'' +
                ", connectionList = " + connectionList;
    }
}
