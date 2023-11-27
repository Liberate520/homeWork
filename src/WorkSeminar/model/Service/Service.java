package WorkSeminar.model.Service;

import WorkSeminar.Test.TestTree;
import WorkSeminar.model.Persona.Gender;
import WorkSeminar.model.Persona.Persona;
import WorkSeminar.model.SaveFile.SaveLoadTree;
import WorkSeminar.model.Tree.Tree;
import java.time.LocalDate;

public class Service {
    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    public Service(){
        tree = new Tree<>();
    }

    public Persona addPersona(String name, String lastName, Gender gender, LocalDate birthday, Persona mather, Persona father){
        Persona pers = new Persona(name, lastName, gender, birthday, mather, father);
        tree.addPersona(pers);
        return pers;
    }
    public Persona addPersona(String name, String lastName, Gender gender, LocalDate birthday){
        Persona pers = new Persona(name, lastName, gender, birthday);
        tree.addPersona(pers);
        return pers;
    }
    public void setWedding(Persona personaOne, Persona personaTwo){
        tree.setWedding(personaOne, personaTwo);
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

    public void seveTree(){
        SaveLoadTree saveTree = new SaveLoadTree();
        saveTree.saveFile("src/WorkSeminar/model/SaveFile/saveTree.out", tree);
    }

    public void loadTree(){
        SaveLoadTree loadTree = new SaveLoadTree();
        tree = (Tree) loadTree.loadFile("src/WorkSeminar/model/SaveFile/saveTree.out");
    }

}


