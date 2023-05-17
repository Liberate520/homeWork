import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E>{
    // класс человек (поля смерть, рождение, отец, мать, дети), enum Gender (male, female), класс дерево (список людей, добавление, поиск), связь через отдельн класс ()
    private List<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addPerson(E person){
        familyTree.add(person);
    }

    public Person getPersonByFirstSecondName(String firstName, String secondName) {
        for (E person: familyTree){
            if (person.getFirstName().equals(firstName) & person.getSecondName().equals(secondName)){
                return (Person) person;
            }
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<E>(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new PersonComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new PersonComparatorByAge<>());
    }
    public String getFamilyTree() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E person: familyTree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
