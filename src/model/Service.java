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
    public Tree tree;

    public Service() {
        file = new TreeFileManager();
    }

    public Tree loadData() throws IOException, ClassNotFoundException {
        TreeFileManager file = new TreeFileManager();
        Tree ft = (Tree)file.loadData();
        return ft;
    }

    public List<Person> getTreeList() throws IOException, ClassNotFoundException {
        return loadData().getPersonList();
    }

    public Tree<Person> sortByName() throws IOException, ClassNotFoundException {
        Tree<Person> ft = loadData();
        ft.sortByName();
        return ft;
    }

    public Tree<Person> sortByDOB() throws IOException, ClassNotFoundException {
        Tree<Person> ft = loadData();
        ft.sortByDOB();
        return ft;
    }

    public Person createNewPerson(List<String> personInfo) throws IOException, ClassNotFoundException {
        Tree<Person> tree = loadData();
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

    public Tree addPersonToTree(Person person) throws IOException, ClassNotFoundException {
        Tree tree = loadData();
        tree.addPerson(person);
        return tree;
    }

    public void saveChangesToFile(Tree tree, boolean confirm) throws IOException {
        if (confirm) {
            file.saveData(tree);
        }
    }
    
}

