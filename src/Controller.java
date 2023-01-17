public class Controller<T extends LiveBeing<T>> {
    FamilyTree<T> familyTree;
    FamilyTreeView<T> familyTreeView;

    public Controller(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
        this.familyTreeView = new FamilyTreeView<>(familyTree);
    }

    void start() {
        String line = null;
        familyTreeView.menu();
        int value = familyTreeView.getValue();
        switch (value) {
            case 1:
                familyTree.showAllInConsole();
                break;
            case 2:
                familyTree.sortByName();
                familyTree.showAllInConsole();
                break;
            case 3:
                familyTree.sortByDate();
                familyTree.showAllInConsole();
                break;
            case 4:
                familyTreeView.getName();
                System.out.println(familyTree.findByName(line));
                break;
            case 5:

                break;
            case 0:
                System.exit(0);
                break;
            default:

                break;
        }

    }
}
