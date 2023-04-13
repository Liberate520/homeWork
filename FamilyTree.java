import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Person> familyTree;

    public FamilyTree(List<Person>familyTree){
        this.familyTree = familyTree;

    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addPerson(Person person) {
        familyTree.add(person);

        }
    
    public void addParents(Person father, Person mother){
        if (father != null){
            familyTree.add(father);
        }
        else if (mother != null){
          familyTree.add(mother);

        } 
    }


    public void addCouple(Person husband, Person wife){ 
        if (husband != null){
            familyTree.add(husband);
        }
        if (wife != null){
            familyTree.add(wife);

        }



    }

    @Override

    public String toString() {
        return familyTree.toString();
    }
}
