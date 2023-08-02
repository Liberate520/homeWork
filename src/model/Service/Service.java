package model.Service;

import model.FamilyTree.FamilyTree;
import model.FamilyTree.FileHolders.FileReader;
import model.FamilyTree.FileHolders.FileSaver;
import model.Organisms.Dogs.Dog;
import model.Organisms.Human.Human;
import model.Organisms.Person.Person;
import model.Organisms.Person.Sex;
import model.Organisms.Person.OrganismType;

import java.time.LocalDate;
import java.util.List;

public class Service{
    private FamilyTree<Person> tree;

    public Service(){
        this.tree = new FamilyTree<>();
    }
    public void addPerson(OrganismType type, String name, LocalDate birthDate, Sex sex) {
        if(type == OrganismType.dog){
            Dog somebody = new Dog(type, name, birthDate, sex);
            tree.addPerson(somebody);
        }else {
            Human somebody = new Human(type, name, birthDate, sex);
            tree.addPerson(somebody);
        }
    }
    public void sortByName(){
        tree.sortByName();
    }
    public void sortByBirthday(){
        tree.sortByBirthday();
    }
    public List<Person> getTree(){
        return tree.getTree();
    }
    public void writeToFile(){
        FileSaver fs = new FileSaver();
        fs.save(tree);
    }
    public void readFromFile(){
        FileReader fr = new FileReader();
        this.tree = fr.read();
    }
    public Person getPerson(int index){
        return tree.getTree().get(index);
    }
}
