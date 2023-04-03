import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Загружаем из файла информацию о людях их связях из файла csv базы
 * Создаем список объектов типа Person
 * Все изменения так же будут записываться в файл
 */
public class Tree implements Iterable<Person> {
    private Map<Integer, Person> persons_list;
    LinkedList<Person> pers_list;

    Tree(FileCSV bd_file){
        persons_list = bd_file.readFile();
        makeRelativesFromCSV();
        fillThePersonsList();
    }

    Tree() {
        persons_list = new HashMap<>();
    }
    // Метод создания родственных связей из айди родителей
    private void makeRelativesFromCSV(){
        int mother_id, father_id;
        for (Map.Entry<Integer, Person> item : persons_list.entrySet()) {
            Person pers = item.getValue();
            
            if (pers.getPerson_info().get("mother_id")!="") {
                mother_id = Integer.parseInt(
                    pers.getPerson_info().get("mother_id")
                    );
                    
                Person mother = this.persons_list.get(mother_id);
                pers.setMother(mother);
                this.persons_list.get(mother_id).setPerson_childs(pers);
            }

            if (pers.getPerson_info().get("father_id")!="") {
                father_id = Integer.parseInt(
                    pers.getPerson_info().get("father_id")
                    );
                    
                Person father = this.persons_list.get(father_id);
                pers.setFather(father);
                this.persons_list.get(father_id).setPerson_childs(pers);
            }
        }
    }
    
    private void fillThePersonsList(){
        this.pers_list = new LinkedList<>();
        for (Person pers : this)
            this.pers_list.add(pers);
    }

    public void sortPersonsByBirthday() {
        Collections.sort(this.pers_list);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Person pers : this.pers_list) {
            res.append("id: "+ pers.getPerson_id() + ":\t");
            res.append(pers.getPerson_name() + "\t\t");
            res.append("Birhday:"+pers.getPersonBirthdayString() + "\n");
        }
        return res.toString();
    }

    public int addPersons(String name){
        Person new_peson = new Person(name);
        this.persons_list.put(new_peson.getPerson_id(), new_peson);
        return new_peson.getPerson_id();
    }

    public Person searchById(int id){
        return persons_list.get(id);
    }


    public ArrayList<Person> searchByName(String name) {
        ArrayList<Person> res_array = new ArrayList<>();
        System.out.println("Ищем людей в базе по имени");
        return res_array;
    }

    public int size(){
        return this.persons_list.size();
    }

    public Person get(int id){
        return this.persons_list.get(id);
    }


    @Override
    public Iterator<Person> iterator() {
        return new TreeIterator();
    }

    class TreeIterator implements Iterator<Person>{
        Iterator<Integer> iterator = persons_list.keySet().iterator();
        int size = persons_list.size();

        @Override
        public boolean hasNext() {
            return size>0;
        }

        @Override
        public Person next() {
            size--;
            return persons_list.get(iterator.next());
        }

    }


}
