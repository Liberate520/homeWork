
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Person> familyTree = new ArrayList<Person>();
    public FamilyTree(List<Person> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<Person> getFamilyTree() {
        return familyTree;
    }

    public boolean addMember(Person newPerson) {
        if (newPerson==null){
            return false;
        }
        this.familyTree.add(newPerson);
        if (newPerson.getFather()!=null)
        {
            newPerson.getFather().addChildrens(newPerson);
        }
        if (newPerson.getMother()!=null)
        {
            newPerson.getMother().addChildrens(newPerson);
        }
        return true;
    }

    public Person getByName(String fio)
    {
    for (Person person : familyTree) {
        if (person.getName().equals(fio))
        {
            return person;
        }
    }
    return null;
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }

}