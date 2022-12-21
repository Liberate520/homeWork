import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trees implements Serializable {
    private List<Human> humanlist;

    public Trees(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    public Trees() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanlist() {
        return humanlist;
    }

    public void sethumanlist(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    public void add_human(Human human) {
        humanlist.add(human);
    }

    @Override
    public String toString() {
        return "Trees [humanlist=" + humanlist + "]";
    }


}
