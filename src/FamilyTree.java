import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree implements Iterable<Human> {
    private ArrayList<Human> familyTree;

    public FamilyTree(){ 
        this.familyTree = new ArrayList<>(); 
    }

    public boolean add(Human human){
        if(!familyTree.contains(human)){
            familyTree.add(human);
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for(Human human: familyTree){
            if(human.getFirstname().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        String info = "";
        for(Human human: familyTree){
            info += human + "\n";
        }
        return info;
    }

    public ArrayList<Human> getFamilyTree(){
        return familyTree;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByDate(){
        familyTree.sort(new HumanComparatorByDate());
    }
}
