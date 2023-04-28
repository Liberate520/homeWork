package familyTree;


import familyTree.fileWorkers.FileWorker;
import familyTree.person.Person;
import familyTree.tree.Tree;

import java.io.Serializable;

public class Service {
    private Tree<Person> currentTree;
    private FileWorker fileWorker;


    public Service(Tree<Person> currentTree) {
        this.currentTree = currentTree;
    }
    public void addPerson(Person person){
        currentTree.addPerson(person);
    }
    public void sortName(){
        currentTree.sortName();
    }
    public void sortAge(){
        currentTree.sortAge();
    }
    public void sortGender(){
        currentTree.sortGender();
    }

    public String getParents(Person person){
        return currentTree.getParents(person);
    }

    public String getChildren(Person person){
        return currentTree.getChildren(person);
    }
    public String getGrandParents(Person person){
        return currentTree.getGrandParents(person);
    }

    public String getInfoTree(){
        return currentTree.getInfoTree();
    }

    public boolean saveFile(Serializable serializable, String filePath) {
        return fileWorker.saveFile(currentTree,filePath);
    }

    public Object readFile(String filePath) {
       return fileWorker.readFile(filePath);
    }




}
