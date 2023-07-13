package family_tree.service;

import family_tree.gender.Gender;
import family_tree.person.Person;
import family_tree.tree.Tree;
import java.time.LocalDate;


public class Service {
    private int idPerson;
    private Tree tree;

    public Service() {
        tree = new Tree();
    }


    public void addPerson(String name,
                          Person partner,
                          LocalDate birthday,
                          LocalDate dayOfDeath,
                          Gender gender,
                          Person mother,
                          Person father) {

        tree.add(new Person(name,
                partner,
                birthday,
                dayOfDeath,
                gender,
                mother,
                father,
                idPerson++));
    }

    public void addPerson(String name,
                          LocalDate birthday,
                          Person partner,
                          Gender gender,
                          Person mother,
                          Person father) {
        tree.add(new Person(name,
                birthday,
                partner,
                gender,
                mother,
                father,
                idPerson++));
    }

    public void addPerson(String name,
                          LocalDate birthday,
                          Gender gender,
                          Person mother,
                          Person father) {
        tree.add(new Person(name,
                birthday,
                gender,
                mother,
                father,
                idPerson++));
    }

    public void addPerson(String name,
                          LocalDate birthday,
                          Gender gender) {
        tree.add(new Person(name,
                birthday,
                gender,
                idPerson++));
    }

    public void addPerson(String name,
                          Person partner,
                          LocalDate birthday,
                          Gender gender) {
        tree.add(new Person(name,
                partner,
                birthday,
                gender,
                idPerson++));
    }

    public void addPerson(String name,
                          LocalDate birthday,
                          LocalDate dayOfDeath,
                          Gender gender) {
        tree.add(new Person(name,
                birthday,
                dayOfDeath,
                gender,
                idPerson++));
    }

    public void addPerson(String name,
                          Person partner,
                          LocalDate birthday,
                          LocalDate dayOfDeath,
                          Gender gender) {
        tree.add(new Person(name,
                partner,
                birthday,
                dayOfDeath,
                gender,
                idPerson++));
    }


    public Person getPerson(Integer id){
        return tree.getPerson(id);
    }

    public Person getPerson(String name){
        return tree.getPerson(name);
    }

    public void reviseDependencies() {
        tree.reviseDependencies();
    }

    public void print(){
        System.out.println(tree);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void saveTreeInFile(String path){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, path);
    }

    public void readTreeFromFile(String path){
        FileHandler fileHandler = new FileHandler();
        tree = (Tree) fileHandler.read(path);
    }

}
