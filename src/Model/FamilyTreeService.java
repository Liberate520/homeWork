package Model;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTreeObject.FamilyTreeObject;
import Model.Write.WriteObject;
import Model.Write.WriteObjectToFile;

import java.io.Serializable;


public class FamilyTreeService <E>{
    private WriteObject writeObjectToFile =new WriteObjectToFile();
    private FamilyTree familyTree = new FamilyTree();
    private FamilyTreeObject familyTreeObject;






    public void saveTree(E e, String fileName){
        writeObjectToFile.write((Serializable) e, fileName);
    }

    public E readTree(String name){

        return (E) writeObjectToFile.read(name);
    }

    public String addElement(String name, String surname, String gender){
        familyTree.addElement(new FamilyTreeObject(familyTree, name, surname, gender));
        if(familyTree.checkElement(name, surname)){
            return "Добавление прошло успешно!";
        }
        return "Добавление не получилось";

    }


    public Boolean deleteElement(String name, String surname) {
        familyTree.deleteElement(name, surname);
        return familyTree.checkElement(name, surname);
    }

    public FamilyTreeObject getElement(String name, String surname) {
        return familyTree.getElement(name, surname);
    }

    public String getElementInfo(String name, String surname){
        return familyTree.getElementInfo(getElement(name,surname));
    }

    public String elemensPrint() {
        return familyTree.elemensPrint();
    }

    public String addChildren(FamilyTreeObject familyTreeObject, String name, String surname, String gender){
        if(familyTreeObject == null){
            return "Родитель не найден!";
        }
        else{
            familyTreeObject.addChildren(new FamilyTreeObject(familyTree, name,surname,gender));
            if(getElement(name, surname) == null){
                return "Ошибка!";
            }
            else{return "Потомок добавлен успешно!";}
        }

    }

    public String addParent(FamilyTreeObject familyTreeObject, String name, String surname, String gender){
        if(familyTreeObject == null){
            return "Объект не найден!";
        }


        if(gender.equalsIgnoreCase("male")){
            familyTreeObject.setFather(new FamilyTreeObject(familyTree, name, surname, gender));

        }

        if(gender.equalsIgnoreCase("female")){
            familyTreeObject.setMother(new FamilyTreeObject(familyTree, name, surname, gender));
        }
        if(getElement(name, surname) == null){
            return "Ошибка!";
        }

        return "Родитель добавлен спешно!";


    }
}
