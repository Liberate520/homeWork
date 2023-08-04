package model.Service;

import model.FamilyTree.FamilyTree;
import model.FamilyTree.FileHolders.Readable;
import model.FamilyTree.FileHolders.Savable;
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
    public void addDog(String name, LocalDate birthDate, Sex sex) {
            Dog somebody = new Dog(OrganismType.dog, name, birthDate, sex);
            tree.addPerson(somebody);
        }
    public void addHuman(String name, LocalDate birthDate, Sex sex) {
        Human somebody = new Human(OrganismType.human, name, birthDate, sex);
        tree.addPerson(somebody);
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
    public void writeToFile(Savable saver){
        saver.save(tree);
    }
    public void readFromFile(Readable reader){
        this.tree = reader.read();
    }
    public Person getPerson(int index){
        return tree.getTree().get(index);
    }

    public void setSpouse(int index1, int index2){
        getPerson(index1).setSpouse(getPerson(index2));
        getPerson(index2).setSpouse(getPerson(index1));
    }
    public void setChild(int indexParent, int indexChild){
        getPerson(indexParent).setChild(getPerson(indexChild));
    }
}
