import java.util.List;

public class Controller<T extends LiveBeing<T>> {
    FamilyTree<T> familyTree;
    FamilyTreeView<T> familyTreeView;

    public Controller(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
        this.familyTreeView = new FamilyTreeView<>(familyTree);
    }

    void start() {
        List<T> list = null;
        while (true) {
            String line = null;
            familyTreeView.menu();
            int value = familyTreeView.getValue();
            switch (value) {
                case 1:
                    list = familyTree.getLiveBeings();
                    familyTreeView.showAllInConsole(list);
                    break;
                case 2:
                    list = familyTree.sortByName();
                    familyTreeView.showAllInConsole(list);
                    break;
                case 3:
                    list = familyTree.sortByDate();
                    familyTreeView.showAllInConsole(list);
                    break;
                case 4:
                    System.out.println(familyTree.findByName(line));
                    break;
                case 5:
                    line = familyTreeView.getName();
                    System.out.println(familyTree.findAllByName(line));
                    break;
                case 0:
                    familyTreeView.exit();
                    System.exit(0);
                    break;
                default:

                    break;
            }
        }
    }
}
