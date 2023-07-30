package familyTree;

import familyTree.enums.Gender;
import familyTree.treeWorkspace.FamilyTree;
import familyTree.treeWorkspace.Person;
import familyTree.treeWorkspace.TreeLoader;

import java.time.LocalDate;

public class Service  {
    private int id;
    private FamilyTree<Person> currentTree;
    private Person tmpPerson;

    public Service() {
        currentTree = new FamilyTree<>();
    }

    public Person addPerson(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        id = currentTree.getMaxId();
        tmpPerson = new Person(id++,name,gender,birthDate,deathDate);
        currentTree.addPerson(tmpPerson);
        return tmpPerson;
    }

    public FamilyTree<Person> getCurrentTree(){
        return currentTree;
    }

    public Person findPerson(int id) {
        for (Person p:currentTree){
            if (id==p.getId()){
                return p;
            }
        }
        return null;
    }
    public int findPersonId(String name, Gender gender){
        for (Person p: currentTree){
            if(p.getName().equals(name)&&p.getGender().equals(gender)){
                return p.getId();
            }
        }
        return -1;
    }
    public void getInfo(){
        for (Person p : currentTree) {
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
    public FamilyTree<Person> loadTree(String path){
        TreeLoader treeLoader = new TreeLoader();
        currentTree = (FamilyTree<Person>) treeLoader.loadTree(path);
        return (FamilyTree<Person>) treeLoader.loadTree(path);
    }
}
