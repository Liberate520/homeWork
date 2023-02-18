import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> humans;

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

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Our writeObject");
    }

    
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Our readObject");
    }
}
