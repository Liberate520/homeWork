import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends HumanInterface<T>> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private List<Human> humanList;

    public List<Human> getHumanList() {
        return humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (human != null) {
            if (!humanList.contains(human)) {
                human.setId(this.id++);
                this.humanList.add(human);
            }
        }
    }

    public void prntHumanList() {

        for (Human human : humanList) {
            HumanPrint h = new HumanPrint(human);
            h.printHumanBasic(human.getSelf());
        }
    }

    public Human findFather(Human human) {
        for (Human h : this.humanList) {
            if (h == human.getFather()) {
                return h;
            }
        }
        return null;
    }

    public Human findMather(Human human) {
        for (Human h : this.humanList) {
            if (h == human.getMather()) {
                return h;
            }
        }
        return null;
    }

    public List<Human> findChildren(Human human) {
        List<Human> lst = new ArrayList<>();
        for (Human h : this.humanList) {
            if (h.getMather() == human || h.getFather() == human) {
                lst.add(h);
            }
        }
        return lst;
    }
}
