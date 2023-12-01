package Family;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Я понял в задании перепутаны понятия, под генеалогическим деревом, подразумеваеться семья.
// Я создал отдельный класс Family.
// Этот тоже оставлю, жалко удалять.
public class FamilyTree implements Serializable {
    private Human rootHuman;
    private List<FamilyTree> heirs;

    public FamilyTree(Human human) {
        rootHuman = human;
        heirs = new ArrayList<>();
        addHeirs(human);
    }

    private void addHeirs(Human human) {
        List<Human> children = human.getChildrens();
        if (!children.isEmpty()) {
            for (Human child : children) {
                heirs.add(new FamilyTree(child));
            }
        }
    }

    @Override
    public String toString() {
        return rootHuman.getName() + " " + rootHuman.getFamilyName() + " " +
                " дети: {" + heirs +
                '}';
    }
}
