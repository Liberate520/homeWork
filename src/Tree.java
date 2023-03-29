import java.util.ArrayList;

public class Tree {

    private ArrayList<Person> famyliTree = new ArrayList<>();

    public void addPerson(Person person) {
        famyliTree.add(person);
        if (person.getMother() != null)
            person.getMother().addChildrens(person);

        if (person.getFather() != null)
            person.getFather().addChildrens(person);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public void findPerson(String name){
        for (Person person : famyliTree) {
            if (person.getName().equals(name))
                System.out.println(person);
        }
    }

}