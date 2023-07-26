package treeWorkspace;

import enums.Gender;

import java.time.LocalDate;

public class Service  {
    // Класс который руководит поведением класса FamilyTree
    private int id;
    private FamilyTree currentTree;
    private Person tmpPerson;

    public Service() {
        currentTree = new FamilyTree();
    }

    public Person addPerson(String name,Gender gender,LocalDate birthDate,LocalDate deathDate){
        // Конструктор для тех, у кого известна дата смерти
        tmpPerson = new Person(id++,name,gender,birthDate,deathDate);
        currentTree.addPerson(tmpPerson);
        return tmpPerson;
    }

    public FamilyTree getCurrentTree(){
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
    public FamilyTree loadTree(String path){
        TreeLoader treeLoader = new TreeLoader();
        return (FamilyTree) treeLoader.loadTree(path);
    }
}
