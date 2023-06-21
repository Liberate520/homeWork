import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Tree<T extends TreeItem> implements Serializable, Iterable<T> {
    private List<T> personList;
    public Tree() {this(new ArrayList<>());}
    public Tree(List<T> personList){
        this.personList = personList;
    }
    public Boolean add(T person){
        if (person == null){
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);
            if (person.getFather() != null){
                person.getFather().addChild((Person) person);
            }
            if (person.getMother() != null){
                person.getMother().addChild((Person) person);
            }
            return true;
        }
        return false;
    }
    public T getByName(String name){
        for (T person : personList){
            if (person.getFullName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public T getById(int id){
        for (T person : personList){
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public String getTreeInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(personList.size());
        sb.append(" объектов: \n");
        for (T person : personList){
            sb.append(person.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return personList.iterator();
    }

    public void sortByName(){
        personList.sort(new PersonComparatorByName<>());
    }

    public void sortByAge(){
        personList.sort(new PersonComparatorByAge<>());
    }
}
