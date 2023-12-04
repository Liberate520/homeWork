package WorkSeminar.model.Service;

import WorkSeminar.Test.TestTree;
import WorkSeminar.model.Persona.Builder.PersonaBuilder;
import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;
import WorkSeminar.model.SaveFile.SaveLoadTree;
import WorkSeminar.model.Tree.Tree;
import java.time.LocalDate;
import java.util.Scanner;

public class Service {
    private Tree<Persona> tree;

    private PersonaBuilder builder;

    private Scanner scanner;

    public Tree getTree() {
        return tree;
    }

    public Service(){
        tree = new Tree<>();
        builder = new PersonaBuilder();
        scanner = new Scanner(System.in);
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

    public void setWedding(long personaOneId, long personaTwoId){
        tree.setWedding(personaOneId, personaTwoId);
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

    public void creatPerson(){
        Persona pers = builder.build();
        tree.addPersona(pers);
    }
    /*
    TODO Ввод из сервиса, придумать алтернативу..
     */
    public void setWedding() {
        long personaOne = Long.parseLong(scanner.nextLine());
        long personaTwo = Long.parseLong(scanner.nextLine());
        setWedding(personaOne, personaTwo);
    }
    /*
    TODO Ввод из сервиса, придумать алтернативу..
     */

    public void addParent(){
        Persona parrentOne = tree.addID(Long.parseLong(scanner.nextLine()));
        Persona parrentTwo = tree.addID(Long.parseLong(scanner.nextLine()));
        Persona kid = tree.addID(Long.parseLong(scanner.nextLine()));
        addParent(parrentOne, parrentTwo, kid);
    }
    /*
    TODO Ввод из сервиса, придумать алтернативу..
     */
    public void addKid(){
        Persona parrent = tree.addID(Long.parseLong(scanner.nextLine()));
        Persona kid = tree.addID(Long.parseLong(scanner.nextLine()));
        addKid(parrent, kid);
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
        SaveLoadTree saveTree = new SaveLoadTree();
        saveTree.saveFile("src/WorkSeminar/model/SaveFile/saveTree.out", tree);
    }

    public void loadTree(){
        SaveLoadTree loadTree = new SaveLoadTree();
        tree = (Tree) loadTree.loadFile("src/WorkSeminar/model/SaveFile/saveTree.out");
    }





}


