package model;

import model.file.File;
import model.person.Gender;
import model.person.Person;
import model.tree.Tree;
import view.PrintData;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    public File file;
    private PrintData printData;

    public Service() {
        file = new File();
        printData = new PrintData();
    }

    public void printLoadData() throws IOException, ClassNotFoundException {
        Tree ft = file.loadData();
        PrintData.printList(ft.getPersonList());
    }

    public Tree<Person> sortByName() throws IOException, ClassNotFoundException {
        Tree<Person> ft = file.loadData();
        ft.sortByName();
        return ft;
    }

    public Tree<Person> sortByDOB() throws IOException, ClassNotFoundException {
        Tree<Person> ft = file.loadData();
        ft.sortByDOB();
        return ft;
    }

    public Person createNewPerson(List<String> personInfo) throws IOException, ClassNotFoundException {
        Tree<Person> tree = file.loadData();
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

}
