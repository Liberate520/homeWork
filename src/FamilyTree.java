import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Human>{
    private ArrayList<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<Human>();
    }

    public ArrayList<Human> getFamilyTree() {
        return familyTree;
    }

    public void addHuman(Human child, Human mother, Human father) {
        familyTree.add(child);
        child.setFather(father);
        child.setMother(mother);
        if (mother != null){
            mother.getChildren().add(child);
        }
        if (father != null){
            father.getChildren().add(child);
        }
    }

    public void addHuman(Human child, Human mother){
        this.addHuman(child, mother, child.getFather());
    }

    public void addHuman(Human child){
        this.addHuman(child, child.getMother(), child.getFather());
    }

    public Human getHuman(String name, String surname) {
        for (int i = 0; i < familyTree.size(); i++) {
            if (familyTree.get(i).getName() == (name)){
                if (surname != null){
                    if (familyTree.get(i).getSurname() == (surname)){
                        return familyTree.get(i);
                    }
                } else {
                    return familyTree.get(i);
                }
                
            }
        }
        return null;
    }
    
    public Human getHuman(String name) {
        return this.getHuman(name, null);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);// return familyTree.iterator();
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge());
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName());
    }
}
