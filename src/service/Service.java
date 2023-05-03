package service;

import human.Gender;
import human.Human;
import familyTree.FamilyTree;
import readWrite.ReadWriteData;
import readWrite.ReadWriteObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service implements Serializable {
    private int id;
    private FamilyTree<Human> activeFamilyTree;
    private List<FamilyTree> familyTreeList;

    public Service(FamilyTree familyTree){
        this.activeFamilyTree = familyTree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(familyTree);
    }
    public Service(){
        this(new FamilyTree());
    }

    public void writeFamilyTreeToFile(String fileName){
        ReadWriteData rw = new ReadWriteObject();
        try {
            rw.writeData(activeFamilyTree.getTree(),fileName);
            System.out.println("Данные записаны в файл " + fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void readFamilyTreeFromFile(String fileName) throws Exception{
        ReadWriteData rw = new ReadWriteObject();
        activeFamilyTree.setTree(rw.readData(fileName));
        this.id = activeFamilyTree.getLastId();
    }

    public void addHuman(String firstName, String lastName, String birthday, Gender gender, Human mother, Human father){
        activeFamilyTree.addHuman(new Human(++id, firstName, lastName,birthday,gender,mother,father));
    }
    public void addHuman(String firstName, String lastName, String birthday, Gender gender, int motherId, int fatherId){
        Human mother = getHumanById(motherId);
        Human father = getHumanById(fatherId);
        addHuman(firstName, lastName, birthday, gender, mother, father);
    }

    public String getInfo(){
        String family = activeFamilyTree.getPeople();
        if (family.isEmpty()){
            return null;
        }
        return family;
    }
    public Human getHuman(String firstName, String lastName, String birthday){
        return activeFamilyTree.getHuman(firstName, lastName, birthday);
    }

    public void sortByFirstName(){
        activeFamilyTree.sortByFirstName();

    }public void sortByLastName(){
        activeFamilyTree.sortByLastName();
    }
    public void sortById(){
        activeFamilyTree.sortById();
    }

    public void sortByNumberOfChildren(){
        activeFamilyTree.sortByNumberOfChildren();
    }

    public void IdentifyChildren(int parentId){
        activeFamilyTree.IdentifyChildren(activeFamilyTree.getHumanById(parentId));
    }
    public void setFather(Human father, Human child){
        child.setFather(father);
        father.setChildren(child);
    }
    public void setMother(Human mother, Human child){
        child.setFather(mother);
        mother.setChildren(child);
    }
    public Human getHumanById(int id){
        return activeFamilyTree.getHumanById(id);
    }

    public String getPeople(){
        return activeFamilyTree.getPeople();
    }
}
