import java.util.ArrayList;
import java.util.List;

public class Trees {
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

    public void setHumanlist(List<Human> humanlist) {
        this.humanlist = humanlist;
    }

    public void add_human(Human human) {
        humanlist.add(human);
    }

    public List<Human> getHumansbyYear(int birth, int death) {
        List<Human> people_year = new ArrayList<>();
        for (Human human : humanlist) {
            if (human.getBirth() <= birth && human.getDeath() >= death) {
                people_year.add(human);
            }
        }
        return people_year;

    }
}
