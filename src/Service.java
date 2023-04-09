import People.Comparators.PersonComparatorByGender;
import People.Comparators.PersonComparatorById;
import People.Comparators.PersonComparatorByIdReverse;
import People.Comparators.PersonComparatorByName;
import People.Person;
import People.TreeElements;
import Tree.FamilyTree;

public class Service {
    private int id;
    private FamilyTree targariensThrone;

    public Service(FamilyTree targariensThrone){
        this.targariensThrone = targariensThrone;
        id = 1;
    }
    public void addTargarien(Person person){
        targariensThrone.addPerson(new Person(id++, person.firstName, person.lastName,
                person.birthDate, person.deathDate, person.gender, person.mother, person.father));
    }
    public void sortByName() {
        targariensThrone.getFamilyTree().sort(new PersonComparatorByName());
    }
    public void sortById(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorById());
    }
    public void sortByIdReverse(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorByIdReverse());
    }
    public void sortByGender(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorByGender());
    }
}
