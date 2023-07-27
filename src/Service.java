import family_tree.FamilyTree;
import person.Gender;
import person.Person;

import java.time.LocalDate;

public class Service {
    private int idPerson;
    private FamilyTree tree;

    public Service() {
        tree = new FamilyTree();
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Person father, Person mother){
        Person person = new Person(firstName, lastName, gender, birthDate, deathDate, father, mother);
        tree.add(person);
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate, Person father, Person mother){
        Person person = new Person(firstName, lastName, gender, birthDate, null, father, mother);
        tree.add(person);
    }

    public void addPerson(String firstName, String lastName, Gender gender, LocalDate birthDate){
        Person person = new Person(firstName, lastName, gender, birthDate, null, null, null);
        tree.add(person);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Person person : tree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }
}
