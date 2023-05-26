package familyTree.model;


import familyTree.model.fileWorkers.FileWorkable;
import familyTree.model.fileWorkers.FileWorker;
import familyTree.model.person.Person;
import familyTree.model.tree.Tree;

import java.io.Serializable;

public class Service implements FileWorkable {
    private Tree<Person> currentTree;
    FileWorker fileWorker = new FileWorker();



    public Service(Tree<Person> currentTree) {
        this.currentTree = currentTree;
    }


    public void addPerson(int age,String gender,String name,String mother,String father){
        Person x = ( currentTree.search(mother)) ;
        Person y = ( currentTree.search(father));
        Person person = new Person(age,gender,name,x,y);
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

    @Override
    public boolean saveFile(Serializable serializable, String filePath) {
        return fileWorker.saveFile(currentTree,filePath);
    }
    @Override
    public Object readFile(String filePath) {
            return fileWorker.readFile(filePath);
        }
    public Person search(String e){
        return currentTree.search(e);
    }




}
