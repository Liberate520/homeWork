import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable{
    ArrayList<Human> FamilyTree;

    public FamilyTree() {
        this.FamilyTree = new ArrayList<Human>();
    }

    public ArrayList<Human> getFamilyTree() {
        return FamilyTree;
    }

    public void addHuman(Human child, Human father, Human mother) {
        FamilyTree.add(child);
        child.setFather(father);
        child.setMother(mother);
        ArrayList<Human> temp = new ArrayList<Human>();
        if (mother != null){
            temp = mother.getChildren();
            temp.add(child);
            mother.setChildren(temp);
        }
        if (father != null){
            temp = father.getChildren();
            temp.add(child);
            father.setChildren(temp);
        }
    }

    public void addHuman(Human child, Human mother){
        this.addHuman(child, null, mother);
    }

    public void addHuman(Human child){
        this.addHuman(child, null, null);
    }

    public Human getHuman(String name, String surname) {
        for (int i = 0; i < FamilyTree.size(); i++) {
            if (FamilyTree.get(i).getName() == (name)){
                if (surname != null){
                    if (FamilyTree.get(i).getSurname() == (surname)){
                        return FamilyTree.get(i);
                    }
                } else {
                    return FamilyTree.get(i);
                }
                
            }
        }
        return null;
    }
    
    public Human getHuman(String name) {
        return this.getHuman(name, null);
    }
}
