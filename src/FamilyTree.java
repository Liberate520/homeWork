import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> personList = new LinkedList<>();

    public void addPerson(Person somebody){
        this.personList.add(somebody);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Person person: personList){
            sb.append("Name: "+person.name+"; Birthday: "+person.birthDate+"\n");
        }
        return sb.toString();
    }
}
