package family_tree.marriage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarriageGroup implements Iterable<Marriage>, Serializable {
    private List<Marriage> marriages;
    public MarriageGroup(){
        marriages = new ArrayList<>();
    }

    public void add(Marriage m){
        marriages.add(m);
    }

    @Override
    public Iterator<Marriage> iterator() {
        return marriages.iterator();
    }
}
