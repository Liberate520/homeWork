package model;

import java.util.List;

public class Service {
    private Tree<Person> family_tree;
    private FileCSV bd_file;

    public Service(Tree<Person> family_tree) {
        this.family_tree = family_tree;
    }

    public Service(String file_name){
        this.bd_file = new FileCSV(file_name);
        this.family_tree = bd_file.readFile();
    }


    public int addPerson(String name) {
        int id = (int) System.currentTimeMillis();
        Person pers = new Person(id, name);
        this.family_tree.add(pers.getPerson_id(), pers);
        return id;
    }

    public FileCSV getBd_file() {
        return this.bd_file;
    }

    public Tree<Person> getFamily_tree() {
        return this.family_tree;
    }

    public String showTheFamily() {
        return this.family_tree.toString();
    }

    public static void sortPersonsById(List<Person> pers_list) {
        pers_list.sort(new ComparatorById());
    }

    public static void sortPersonsByName(List<Person> pers_list) {
        pers_list.sort(new ComparatorByName());
    }
}
