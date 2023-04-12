package model;

import java.util.List;

import model.comparator.ComparatorById;
import model.comparator.ComparatorByName;
import model.file.FileBinary;
import model.file.FileCSV;
import model.person.Person;

public class Service {
    private Tree<Person> family_tree;
    private FileCSV bd_csv;
    private FileBinary bd_binary;

    public Service(Tree<Person> family_tree) {
        this.family_tree = family_tree;
    }

    public Service(String file_name, String type) throws ClassNotFoundException{
        if (type.equals("csv")){
            this.bd_csv = new FileCSV(file_name);
            this.family_tree = bd_csv.readFile();
        }

        if (type.equals("binary")){
            this.bd_binary = new FileBinary(file_name);
            this.family_tree = bd_binary.readFile();
        }
    }


    public int addPerson(String name) {
        int id = (int) System.currentTimeMillis();
        Person pers = new Person(id, name);
        this.family_tree.add(pers.getPerson_id(), pers);
        return id;
    }

    public void setBd_binary(FileBinary bd_binary) {
        this.bd_binary = bd_binary;
    }

    public void setBd_csv(FileCSV bd_csv) {
        this.bd_csv = bd_csv;
    }

    public FileBinary getBd_binary() {
        return bd_binary;
    }

    public FileCSV getBd_csv() {
        return this.bd_csv;
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
