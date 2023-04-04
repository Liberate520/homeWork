import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeFamily implements Serializable {
    private List<Human> list;

    public TreeFamily() {
        list = new ArrayList<>();
    }


    public void addHuman(Human human) {
        list.add(human);
    }

    public Human getByMather(Human human) {
        for (Human hum : list) {
            if (hum.getMother().equals(human.getMother())) {
                return hum;
            }
        }
        return null;
    }


    public void addKid(Human kid) {
        for (Human hum : list) {
            if (kid.getMother().equals(hum)
                    || kid.getFather().equals(hum)) {
                hum.addChildrenList(kid);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeFamily{" +
                "list=" + list +
                '}';
    }

    public void save(Writable writable) throws IOException {
        writable.save(this);

    }


}
