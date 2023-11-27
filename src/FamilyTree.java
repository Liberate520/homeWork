import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// В этом классе я реализую, генеалогическое дерево, через структуру данных дерево
// человек здесь является корнем дерева и от каждого его ребенка идет свое поддерево
// таким образом дерево будет содержать еще и внуков, правнуков и т.д.
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
        return rootHuman.getName() + " " + rootHuman.getFamilyName() +
                " дети: {" + heirs +
                '}';
    }
}
