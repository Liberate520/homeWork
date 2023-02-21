import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> humans;
    private Writable fileHandler;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    private FamilyTree(List<Human> humans) {
        this.humans = humans;
    }
    
    public String getChildrenToString(Human human) {
        String res = "Дети от родителя "+ human.getInfo()+": ";
        List<Human> children = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getFather() == human){
                children.add(humans.get(i));
            }
        }
        for (int i = 0; i < children.size(); i++) {
            res = res +"\n"+(i+1) +"). " +children.get(i).getInfo();
        }
        return res;
    }

    public String getAllHumanToString() {        
        String res = "Генеологическое дерево: ";
        List<Human> list1 = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            list1.add(humans.get(i));
        }       
        for (int i = 0; i < humans.size(); i++) {
            res = res +"\n"+(i+1) +"). " +humans.get(i).getInfo();
        }
        return res;
    }

    public void addHuman(Human human) {
        humans.add(human);
        if (human.getFather()!=null){
            human.getFather().addChild(human);
        }
        if (human.getMother()!=null){
            human.getMother().addChild(human);
        }
    }

    public Human getByName (String name) {
        for (Human human:humans){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public void save() throws FileNotFoundException{
        fileHandler.save("FamTree.out");
    }

    public void read() throws FileNotFoundException{
        fileHandler.save("FamTree.out");
    }

    public void setFileHandler(Writable fileHandler){
        this.fileHandler=fileHandler;
    }

    @Override
    public Iterator<Human> iterator() {
        
        return new HumanIterator(humans);
    }  
    
   
    public void sortByName(){
        Collections.sort(humans, new HumanComparatorByName());
    }

    public void sortByYearBirth(){
        Collections.sort(humans, new HumanComparatorByYearBirth());
    }
    


}
