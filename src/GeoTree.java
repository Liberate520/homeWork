import java.lang.reflect.Array;
import java.util.ArrayList;

public class GeoTree {
    private ArrayList<Person> personList;

    public GeoTree(){
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void searchPerson(Person person) {
        for (Person item : personList) {
            if (item.equals(person)) {
                System.out.print(item + " ");
                System.out.println(item.getRelation());
            }
        }
    }
}
