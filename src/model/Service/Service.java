package model.Service;

import model.FamilyTree.FamilyTree;
import model.FamilyTree.FileHolder;
import model.Organisms.Human.Human;
import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Organisms.Person.OrganismType;

import java.time.LocalDate;

public class Service{
    private FamilyTree tree;

    public Service(){
        this.tree = new FamilyTree();
    }
    public void addPerson(OrganismType type, String name, LocalDate birthDate, Sex sex) {
        Human somebody = new Human(type, name, birthDate, sex);
        tree.addPerson(somebody);
    }
    public void sortByName(){
        tree.sortByName();
    }
    public void sortByBirthday(){
        tree.sortByBirthday();
    }
    public void setChild(Person adult, Person child){
        adult.setChild(adult, child);
    }
    public FamilyTree getTree(){
        return this.tree;
    }
    public void writeToFile(){
        FileHolder fh = new FileHolder();
        fh.save(tree);
    }
    public void readFromFile(){
        FileHolder fh = new FileHolder();
        this.tree = fh.read();
    }




}
