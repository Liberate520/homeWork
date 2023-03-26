import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Загружаем из файла информацию о людях их связях из файла csv базы
 * Создаем список объектов типа Person 
 * Все изменения так же будут записываться в файл
 */
public class Tree {
    private Map<Integer, Map<String, String>> bd_tree;
    private String bd_file;
    private static String default_file = "bd.csv";
    public ArrayList<Person> persons_list;
    
    Tree(String file_name){
        this.bd_file = new File(file_name).getAbsolutePath();   
        if (bdExist()) {
            bdLoad();
        } else {
            System.out.println("Создаем файл новой базы данных");
        }
    }

    Tree(){
        this(default_file);
    }

    private Boolean bdExist(){
        File file = new File(this.bd_file);
        return file.exists();
    }

    private void bdLoad(){
        System.out.println("Загружаем базу с людьми");
        System.out.println("Формируем список с объектами класса Person");
    }

    private void bdSave(){
        System.out.println("Сохраняем изменения в файл");
        System.out.println("Формируем список с объектами класса Person");
    }

    public int addPersons(String name){
        Person new_pesons = new Person();
        persons_list.add(new_pesons);
        bd_tree.put(new_pesons.getPerson_id(), new_pesons.getPersonInfo());
        return new_pesons.getPerson_id();
    }

    public Boolean addPersonsParents(int id, String key){
        System.out.println("добовляем айди Матери или Отца");
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
