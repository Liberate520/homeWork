import java.util.List;
import java.util.ArrayList;

public class Tree {
    private List<Person> PersonList;
    private TypeOfCommunication communication;


    public Tree() {
        PersonList = new ArrayList<>();
    }

    public void addPerson(Person Person){
        PersonList.add(Person);
    }

    public void FindPersonByName(String name){
        for (Person Person: PersonList) {
            if (Person.getSurname().equalsIgnoreCase(name)){
                return Person;
            }
        }
    }
}
