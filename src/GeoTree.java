import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class GeoTree {
    private ArrayList<Person> personList;

    public GeoTree(){
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public Map <Person, Map<Person, Relation>> searchPerson(Person person) {
        Map <Person, Map<Person, Relation>> searchResult = new HashMap();
        for (Person item : personList) {
            if (item.equals(person)) {
                searchResult.put(item, item.getRelation());
            }
        }
        return searchResult;
    }
}