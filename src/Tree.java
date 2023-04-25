import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> humantree;

    public Tree() {
        humantree = new ArrayList<>();
    }
    public void addTree(Human human){
        humantree.add(human);
    }

    public List<Human> getHumantree() {
        return humantree;
    }

    public void setHumantree(List<Human> humantree) {
        this.humantree = humantree;
    }

    @Override
    public String toString() {
        return "Дерево" + humantree;
    }
}