import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    // класс человек (поля смерть, рождение, отец, мать, дети), enum Gender (male, female), класс дерево (список людей, добавление, поиск), связь через отдельн класс ()
    private List<Person> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(Person person){
        familyTree.add(person);
    }

    public Person getPersonByFirstSecondName(String firstName, String secondName) {
        for (Person person: familyTree){
            if (person.getFirstName().equals(firstName) & person.getSecondName().equals(secondName)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new PersonComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new PersonComparatorByAge<>());
    }
    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person: familyTree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
