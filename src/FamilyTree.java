import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable,Iterator<Human> {
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humanList) {
            sb.append(human.toString());
            sb.append("/n");
        }
        return sb.toString();
    }



    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Human next() {
        return null;
    }

    public static Human FamilyTree() {
        return null;
    }
}


    





