package homeWork;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class FamilyTree implements Serializable, Iterable<Human>{
    public static final char[] humamList = null;
    private List<Human> humanList;
    public FamilyTree() {this(new ArrayList<>());}

    public FamilyTree(List<Human> humanList) {this.humanList = humanList;}

    public boolean add(Human humanlist){
        if (humanlist == null){
            return false;
        }
        if(!humanList.contains(humanlist)){
            humanList.add(humanlist);
            if(humanlist.getFather() != null){
                humanlist.getFather().addChild(humanlist);
            }
            if(humanlist.getMother() != null){
                humanlist.getMother().addChild(humanlist);
            }
            return true;
        }
        return false;
    }

    public Human getByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        System.out.println("В дереве " + humanList.size() + " объекта/ов: ");
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < humanList.size(); i++){
                sb.append("\n");
                sb.append(humanList.get(i).getInfo());
            }
    return sb.toString();
    }

    // public void sortByName(){
    //     Collection.sort(Human.getHumanList());
    // }
    public List<Human> getHumanList() {
        return humanList;
    }

    public void sortFamilyTree() {
        Collections.sort(this.getHumanList());

    }

    @Override
    public Iterator<Human> iterator() {
        // return humanList.iterator();
        return new FamilyTreeIterator(humanList);
    }
}
    

    

   
   
    

