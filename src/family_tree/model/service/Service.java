package family_tree.model.service;

import family_tree.model.dog.Dog;
import family_tree.model.gender.Gender;
import family_tree.model.person.Person;
import family_tree.model.tree.Tree;
import family_tree.model.tree.Treeable;

import java.time.LocalDate;


public class Service<E extends Treeable<E>> {
    private int idPerson;
    private String type;
    private Tree tree;

    public Service(String type) {
            this.tree = new Tree<E>();
            this.type = type;
    }

    public void add(String name,
                    LocalDate birthday,
                    LocalDate dayOfDeath,
                    Gender gender){

        if (type.equals("Person")) {
            this.tree.add(new Person(name,
                    birthday,
                    dayOfDeath,
                    gender,
                    idPerson++));
        } else {
            this.tree.add(new Dog(name,
                    birthday,
                    dayOfDeath,
                    gender,
                    idPerson++));
        }
    }

//        public void addPerson(String name,
//                          E partner,
//                          LocalDate birthday,
//                          LocalDate dayOfDeath,
//                          Gender gender,
//                          E mother,
//                          E father) {
//
//        tree.add(new E(name,
//                partner,
//                birthday,
//                dayOfDeath,
//                gender,
//                mother,
//                father,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          LocalDate birthday,
//                          Person partner,
//                          Gender gender,
//                          Person mother,
//                          Person father) {
//        tree.add(new Person(name,
//                birthday,
//                partner,
//                gender,
//                mother,
//                father,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          LocalDate birthday,
//                          Gender gender,
//                          Person mother,
//                          Person father) {
//        tree.add(new Person(name,
//                birthday,
//                gender,
//                mother,
//                father,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          LocalDate birthday,
//                          Gender gender) {
//        tree.add(new Person(name,
//                birthday,
//                gender,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          Person partner,
//                          LocalDate birthday,
//                          Gender gender) {
//        tree.add(new Person(name,
//                partner,
//                birthday,
//                gender,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          LocalDate birthday,
//                          LocalDate dayOfDeath,
//                          Gender gender) {
//        tree.add(new Person(name,
//                birthday,
//                dayOfDeath,
//                gender,
//                idPerson++));
//    }
//
//    public void addPerson(String name,
//                          Person partner,
//                          LocalDate birthday,
//                          LocalDate dayOfDeath,
//                          Gender gender) {
//        tree.add(new Person(name,
//                partner,
//                birthday,
//                dayOfDeath,
//                gender,
//                idPerson++));
//    }


//    public E getPerson(Integer id){
//        return tree.getPerson(id);
//    }

    public Object getPerson(String name){
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
