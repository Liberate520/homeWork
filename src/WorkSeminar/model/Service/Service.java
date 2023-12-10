package WorkSeminar.model.Service;

import WorkSeminar.Test.TestTree;
import WorkSeminar.model.Persona.Builder.Input;
import WorkSeminar.model.Persona.Builder.InputID;
import WorkSeminar.model.Persona.Builder.PersonaBuilder;
import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;
import WorkSeminar.model.SaveFile.ReadLoadable;
import WorkSeminar.model.SaveFile.SaveLoadTree;
import WorkSeminar.model.Tree.Tree;
import WorkSeminar.model.Tree.TreeEtem;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Service {
    private Tree<Persona> tree;
    private PersonaBuilder builder;
    private ReadLoadable readLoadable;
    private String pathFile;
    public Tree getTree() {
        return tree;
    }
    public Service(){
        tree = new Tree<>();
        pathFile = "src/WorkSeminar/model/SaveFile/saveTree.out"; //Дефолтный адрес сохранения/загрузки
        builder = new PersonaBuilder();
        readLoadable = new SaveLoadTree();
    }
    //Методы для ручной настройки тестового древа.
    public Persona addPersona(String name, String lastName, Gender gender, LocalDate birthday, Persona mather, Persona father){
        Persona pers = new Persona(name, lastName, gender, birthday, mather, father);
        tree.addPersona(pers);
        return pers;
    }
    public Persona addPersona(String name, String lastName, Gender gender, LocalDate birthday){
        Persona pers = new Persona(name, lastName, gender, birthday);
        tree.addPersona(pers);
        tree.getPersonID();
        return pers;
    }
    public void addKid(Persona parent, Persona kid){
        parent.addKid(kid);
    }
    public  void addParent(Persona parentM, Persona parentF, Persona kid){
        kid.addParent(parentM, parentF);
    }
    public  void addParent(Persona parent, Persona kid){
        kid.addParent(parent);
    }

    // Методы консольной настройки древа.

    public void creatPerson(Scanner scanner){
        Persona pers = builder.build(scanner);
        tree.addPersona(pers);
    }

    public void setWedding(long personaOneId, long personaTwoId){
        tree.setWedding(personaOneId, personaTwoId);
    }

    public void addParent(long personaOne, long personaTwo, long personaKid){
        Persona parrentOne = tree.addID(personaOne);
        Persona parrentTwo = tree.addID(personaTwo);
        Persona kid = tree.addID(personaKid);
        addParent(parrentOne, parrentTwo, kid);
        addKid(parrentOne, kid);
        addKid(parrentTwo, kid);
    }

    public void addKid(long personaOne, long personaKid){
        Persona parrent = tree.addID(personaOne);
        Persona kid = tree.addID(personaKid);
        addKid(parrent, kid);
        addParent(parrent, kid);
    }

    public  void setDathday(long persona, LocalDate date){
        Persona daethPersona = tree.addID(persona);
        daethPersona.setDathday(date);
    }

    public void getSisBroth(long id){
        List<Persona> sisterAndBrozer = tree.getSisBroth(id);
        tree.printSisBroth(sisterAndBrozer);
    }

    public void createTree(){
        TestTree test = new TestTree();
        tree = test.test();
    }

    public String showTree(){
        StringBuilder treeInfo = new StringBuilder();
        treeInfo.append("Семейное древо: \n");
        for (Object persona: tree){
            treeInfo.append(persona);
            treeInfo.append("\n");
        }
        return treeInfo.toString();
    }

    public String getNamePersona(String name){
        List<Persona> list = tree.getNamePersona(name);
        StringBuilder persInfo = new StringBuilder();
        persInfo.append("Список искомых имён: \n");
        if(list.size() > 0){
            for (Object persona: list){
                persInfo.append(persona);
                persInfo.append("\n");
            }
        } else {
            persInfo.append("В древе нет персонажей с данным именем. \n");
        }
        return persInfo.toString();
    }

    public void sortTreeByName(){
        tree.sortTreeByName();
    }

    public void sortTreeByAge(){
        tree.sortTreeByAge();
    }

    public void sortDefaut(){
        tree.sortDefaut();
    }

    public void sortTreeByGender(){
        tree.sortTreeByGender();
    }

    public boolean endWork(){
        return false;
    }

    public void saveTree(){
        readLoadable.saveFile(pathFile, tree);
    }

    public void loadTree(){
        tree = (Tree) readLoadable.loadFile(pathFile);
    }

    public void setPathFile(String path){
        pathFile = path;
    }
    public void defoldPathFile(){
        pathFile = "src/WorkSeminar/model/SaveFile/saveTree.out";
    }
    public String getPathFile(){
        return pathFile;
    }
}


