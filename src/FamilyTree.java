import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Person> targariens;

    public FamilyTree(List<Person> targariens) {
        this.targariens = targariens;
    }

    public FamilyTree() {
        this.targariens = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.targariens.add(person);
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

    public void personParents(Person person) {
        Person mather = null;
        Person father = null;
        for (Person item : targariens) {
            if (item.getId() == person.getIdMather()) {
                mather = person;
            }
            if (item.getId() == person.getIdFather()) {
                father = person;
            }
        }
        System.out.println("Person - " + person + "\n" + "mather - " + mather +
                "\n" + "Father - " + father);
    }

//    public static void descendantsSearch(List<Person> list, String input){
//
//        List<Person> descebdants = new ArrayList<>();
//        for (Person name:list){
//            if (name.equals(input)){
//                System.out.println(descebdants);
//            }
//        }
    public void descendantSearch(Person person){
        List<Person> descendantsNew = new ArrayList<>();
        for (Person item:targariens) {
            if (item.getIdFather() == person.getId() || item.getIdMather() == person.getId()) {
                descendantsNew.add(person);
            }
            if (descendantsNew.size() > 0) {
                System.out.printf("Ascentor - " + person + "\n");
                for (Person i : descendantsNew) {
                    System.out.println(i);
                }

//            }else System.out.printf("Ascentor - " + person + " have no descendants" + "\n");
            }
        }
    }

    @Override
    public String toString() {
        for (Person person : targariens) {
            System.out.println(person);
        }
        return "\n";
    }
}
