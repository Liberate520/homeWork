import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(Human human) {
        this.familyTree.add(human);
    }

    @Override
    public String toString() {
        for (Human item : familyTree) {
            System.out.println(item);
        }
        return " ";
    }

    public void parentsHuman(Human human) {
        Human mather = null;
        Human father = null;
        for (Human item : familyTree) {
            if (item.getId() == human.getIdMather()) mather = item;
            if (item.getId() == human.getIdFather()) father = item;
        }
        System.out.printf("Исследуемый объект:\n%s\nМать - %s\nОтец - %s", human, mather, father);
    }

    public void childrensHuman(Human human) {
        List<Human> childrens = new ArrayList<>();
        for (Human item : familyTree) {
            if (item.getIdFather() == human.getId() || item.getIdMather() == human.getId()) {
                childrens.add(item);
            }
        }
        if (childrens.size() > 0) {
            System.out.printf("\nИсследуемый объект:\n%s\nДети объекта:\n", human);
            for (Human item : childrens) System.out.print(item);
        } else System.out.printf("\nИсследуемый объект:\n%s\nДетей нет", human);
    }

}
