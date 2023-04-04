import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Загружаем из файла информацию о людях их связях из файла csv базы
 * Создаем список объектов типа Person
 * Все изменения так же будут записываться в файл
 */
public class Tree implements Iterable<Person> {
    private Map<Integer, Person> persons_list;
    // List<Person> pers_list;
    // private String file_name;

    Tree() {
        persons_list = new HashMap<>();
    }

    public List<Person> getThePersonsList() {
        List<Person> pers_list = new LinkedList<>();
        for (Person pers : this)
            pers_list.add(pers);
        return pers_list;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Person pers : this) {
            res.append("id: " + pers.getPerson_id() + ":\t");
            res.append(pers.getPerson_name() + "\t\t");
            res.append("Birhday:" + pers.getPersonBirthdayString() + "\n");
        }
        return res.toString();
    }

    public int addPersons(String name) {
        Person new_peson = new Person(name);
        this.persons_list.put(new_peson.getPerson_id(), new_peson);
        return new_peson.getPerson_id();
    }

    public void addPersonToTree(int id, Person pers) {
        this.persons_list.put(id, pers);
    }

    public Person searchById(int id) {
        return persons_list.get(id);
    }

    public ArrayList<Person> searchByName(String name) {
        ArrayList<Person> res_array = new ArrayList<>();
        System.out.println("Ищем людей в базе по имени");
        return res_array;
    }

    public int size() {
        return this.persons_list.size();
    }

    public Person get(int id) {
        return this.persons_list.get(id);
    }

    @Override
    public Iterator<Person> iterator() {
        return new TreeIterator(this.persons_list);
    }

}
