import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Загружаем из файла информацию о людях их связях из файла csv базы
 * Создаем список объектов типа Person
 * Все изменения так же будут записываться в файл
 */
public class Tree {
    public Map<Integer, Person> persons_list;

    Tree(Map<Integer, LinkedHashMap<String, String>> bd_tree) {

        persons_list = new HashMap<Integer, Person>();

        for (Map.Entry<Integer, LinkedHashMap<String, String>> bd_item : bd_tree.entrySet()) {
            Person pers = new Person(bd_item.getKey(), bd_item.getValue());
            persons_list.put(bd_item.getKey(), pers);
        }

        makeRelatives(bd_tree);
    }

    // Tree() {
    //     Map<Integer, LinkedHashMap<String, String>> bd_tree = new HashMap<>();
    //     this(bd_tree);
    // }

    public void makeRelatives(Map<Integer, LinkedHashMap<String, String>> bd_tree){
        int id, mother_id, father_id;
        for (Map.Entry<Integer, LinkedHashMap<String, String>> bd_item : bd_tree.entrySet()) {
            id = bd_item.getKey();
            
            if (bd_item.getValue().get("mother_id")!=""){
                mother_id = Integer.parseInt(
                    bd_item.getValue()
                    .get("mother_id")
                    );
                
                Person mother = persons_list.get(mother_id);
                this.persons_list.get(id).setMother(mother);
                
                Person child = persons_list.get(id);
                this.persons_list.get(mother_id).setPerson_childs(child);
            }

            if (bd_item.getValue().get("father_id")!=""){
                father_id = Integer.parseInt(
                    bd_item.getValue()
                    .get("father_id")
                    );
                Person father = persons_list.get(father_id);
                this.persons_list.get(id).setFather(father);

                Person child = persons_list.get(id);
                this.persons_list.get(father_id).setPerson_childs(child);
            }


        }
    }

    public void show() {
        for (Map.Entry<Integer, Person> pers : this.persons_list.entrySet()) {
            System.out.printf("id: %d \t name: %s\n", pers.getValue().getPerson_id(), pers.getValue().getPerson_name());
        }
    }

    

    public int addPersons(String name){
        Person new_peson = new Person(name);
        this.persons_list.put(new_peson.getPerson_id(), new_peson);
        return new_peson.getPerson_id();
    }

    public Person searchById(int id){
        return persons_list.get(id);
    }

    public Boolean addPersonsParents(int id, String key) {
        System.out.println("добавляем айди Матери или Отца");
        System.out.println("или детей");
        System.out.println("также можно добавить любые другие параметры, для доп информации");
        return true;
    }

    public ArrayList<Person> searchByName(String name) {
        ArrayList<Person> res_array = new ArrayList<>();
        System.out.println("Ищем людей в базе по имени");
        return res_array;
    }

}
