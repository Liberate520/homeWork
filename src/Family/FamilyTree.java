package Family;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Я понял в задании перепутаны понятия, под генеалогическим деревом, подразумеваеться семья.
// Я создал отдельный класс Family.
// Этот тоже оставлю, жалко удалять.
public class FamilyTree<E extends FamilyMember> implements Serializable {
    private E rootHuman;
    private List<FamilyTree> heirs;

    public FamilyTree(E e) {
        rootHuman = e;
        heirs = new ArrayList<>();
        addHeirs(e);
    }

    private void addHeirs(E e) {
        List<E> children = (List<E>) e.getChildrens();
        if (!children.isEmpty()) {
            for (E child : children) {
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
