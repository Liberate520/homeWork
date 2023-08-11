package model;

import model.tree.FamilyTree;
import model.tree.FileReadWrite;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Person> familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public boolean addPerson(String firstName, String lastName, String surName,
                          LocalDate dateOfBirth, Gender gender){

        Person person = new Person(familyTree.humanListSize() + 1, firstName, lastName, surName, dateOfBirth, gender);
        familyTree.addHumanList(person);
        return true;
    }


    /**
     * Получение полного списка людей в древе
     * @return
     */
    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список всех людей: \n");
        for (Person human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public String findPerson(String name) {
        return familyTree.findPerson(name);
    }

    public void setMather (int idChild, int idMather){
        Person child = familyTree.getPersonById(idChild);
        Person mather = familyTree.getPersonById(idMather);
        child.setMather(mather);
    }

    public void setFather (int idChild, int idFather){
        Person child = familyTree.getPersonById(idChild);
        Person father = familyTree.getPersonById(idFather);
        child.setFather(father);
    }

    public int getHumanListSize(){
        return familyTree.humanListSize();
    }

    public Person getPersonById(int id){
       return familyTree.getPersonById(id);
    }

    public void saveTree() throws IOException {
        FileReadWrite save = new FileReadWrite();
        save.writeTree(familyTree);
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        FileReadWrite load = new FileReadWrite();
        familyTree = load.readTree();
    }

    public String getChildren(int id){
       return familyTree.getPersonById(id).getChildren();
    }


}
