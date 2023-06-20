package model;

import model.file.TreeFileManager;
import model.person.Gender;
import model.person.Person;
import model.tree.Tree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    public TreeFileManager file;

    public Service() {
        file = new TreeFileManager();
    }

    public List<Person> loadData() throws IOException, ClassNotFoundException {
        TreeFileManager file = new TreeFileManager();
        Tree ft = (Tree) file.loadData();
        return ft.getPersonList();
    }

    public Tree<Person> sortByName() throws IOException, ClassNotFoundException {
        Tree<Person> ft = (Tree) file.loadData();
        ft.sortByName();
        return ft;
    }

    public Tree<Person> sortByDOB() throws IOException, ClassNotFoundException {
        Tree<Person> ft = (Tree)file.loadData();
        ft.sortByDOB();
        return ft;
    }

    private Person createNewPerson(List<String> personInfo) throws IOException, ClassNotFoundException {
        Tree<Person> tree = (Tree)file.loadData();
        Person person =
                new Person(personInfo.get(0),
                LocalDate.of(Integer.parseInt(personInfo.get(1)),
                        Integer.parseInt(personInfo.get(2)),
                        Integer.parseInt(personInfo.get(3))),
                null);
        // set gender
        if (personInfo.get(4).equals("m")) {
            person.setGender(Gender.Male);
        }
        else {
            person.setGender(Gender.Female);
        }
        // set mother
        if (personInfo.get(5).equals("-") || personInfo.get(5).equals("")) {
            person.setMother(null);
        }
        else {
            person.setMother(tree.findPersonByName(personInfo.get(5)));
        }
        // set father
        if (personInfo.get(6).equals("-") || personInfo.get(6).equals("")) {
            person.setFather(null);
        }
        else {
            person.setFather(tree.findPersonByName(personInfo.get(6)));
        }
        return person;
    }

    public void addNewPerson() throws IOException, ClassNotFoundException {
        Person person = createNewPerson(view.getNewPersonInfo());
        Tree tree = (Tree) file.loadData();
        tree.addPerson(person);
        if (view.askToSave()) {
            file.saveData(tree);
        }
    }

}

