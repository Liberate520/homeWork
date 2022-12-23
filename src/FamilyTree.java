import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> humanList;
    private Writable writer;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public String toString() {
        String s = "";
        for (Human human: humanList) {
            s += human + "\n";
        }
        return s;
    }

    public void addHuman(Human human){
        humanList.add(human);
    }

    public Human getHumanByName(String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public void setWriter(Writable writer) {
        this.writer = writer;
    }

    public void save() {
        if (writer != null)
            writer.save(this);
    }

    public void load() {
        if (writer != null) {
            FamilyTree loadTree = writer.load();
            if (loadTree != null)
                this.setHumanList(loadTree.getHumanList());
        }
    }
}
