package familyTree;

import familyTree.enums.Gender;
import familyTree.treeWorkspace.FamilyTree;
import familyTree.treeWorkspace.Person;
import familyTree.treeWorkspace.TreeItem;
import familyTree.treeWorkspace.TreeLoader;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Service<E extends TreeItem<E>>  {
    // Класс который руководит поведением класса FamilyTree
    private int id;
    private FamilyTree<E> currentTree;
    private Object tmpPerson;

    public Service() {
        currentTree = new FamilyTree<>();
    }

    public E addPerson(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        id = currentTree.getMaxId();
        tmpPerson = new Person(id++,name,gender,birthDate,deathDate);
        currentTree.addPerson((E)tmpPerson);
        return (E) tmpPerson;
    }

    public FamilyTree<E> getCurrentTree(){
        return currentTree;
    }

    public E findPerson(int id) {
        for (E p:currentTree){
            if (id==p.getId()){
                return p;
            }
        }
        return null;
    }
    public int findPersonId(String name, Gender gender){
        for (E p: currentTree){
            if(p.getName().equals(name)&&p.getGender().equals(gender)){
                return p.getId();
            }
        }
        return -1;
    }
    public void getInfo(){
        for (E p : currentTree) {
            System.out.println(p);
        }
    }
    public void sortByName(){
        currentTree.sortByName();
    }
    public void sortByAge(){
        currentTree.sortByAge();
    }
    public void sortByGender(){
        currentTree.sortByGender();
    }
    public void saveTree(String path){
        TreeLoader treeLoader = new TreeLoader();
        treeLoader.saveTree(currentTree,path);
    }
    public FamilyTree<E> loadTree(String path){
        TreeLoader treeLoader = new TreeLoader();
        currentTree = (FamilyTree<E>) treeLoader.loadTree(path);
        return (FamilyTree<E>) treeLoader.loadTree(path);
    }
}
