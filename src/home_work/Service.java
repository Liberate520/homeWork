package home_work;

public class Service {
    private FamilyTree tree;

    public Service() {
        tree = new FamilyTree();
    }

    public void craateLink(Human parent, Human child) {
        parent.addChildren(child);
        child.addParent(parent);
    }

    public void createTree(Human human) {
        tree.createTree(human);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree: \n");
        for (Human human : tree) {
            if (!human.getChildrens().isEmpty()) {
                stringBuilder.append(human.getName() + " childrens: " + human.getChildrensName() + "\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }
}
