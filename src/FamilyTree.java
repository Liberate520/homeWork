import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    public List<Person> targariens;

    public FamilyTree(List<Person> targariens) {
        this.targariens = targariens;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }
//    Не удалось сделать метод VOID.
    public boolean addPerson(Person person){
        if (person == null){
            return false;
        }
        if (!targariens.contains(person)){
            targariens.add(person);
            if (person.getFather() != null){
                person.getFather().addDescendants(person);
            }
            if (person.getMother() != null) {
                person.getMother().addDescendants(person);
            }
            return true;
        }
        return false;
    }

    public List<Person> searchPerson(String firstName){
        List<Person> searched = new ArrayList<>();
        for (Person item:targariens) {
            if (item.getFirstName().equals(firstName)){
                searched.add(item);
            }
        }
        return searched;
    }

    public List<String> searchPersonDescendance(String firstName){
        List<String> searched = new ArrayList<>();
        for (Person item: targariens) {
            if (item.getFirstName().equals(firstName)){
                searched.add(item.getDescendantInfo());
            }
        }
        return searched;
    }

    public String getTreeInfo(){
        StringBuilder tree = new StringBuilder();
        for (Person ppl:targariens) {
            tree.append(ppl.getInfo());
            tree.append("\n");
        }
        return tree.toString();
    }
}
