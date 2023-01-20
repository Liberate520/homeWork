import java.util.List;

public class Controller<T extends LiveBeing<T>> {
    String filePath;
    FamilyTree<T> familyTree;
    FamilyTreeView<T> familyTreeView;
    InputOutputList<T> inputOutput;

    public Controller(FamilyTree<T> familyTree, String filePath) {
        this.filePath = filePath;
        this.familyTree = familyTree;
        this.familyTreeView = new FamilyTreeView<>();
        this.inputOutput = new InputOutputList<>();
    }

    void start() {
        T liveBeing = null;
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
                    line = familyTreeView.getName();
                    liveBeing = familyTree.findByName(line);
                    familyTreeView.showLiveBeing(liveBeing);
                    break;
                case 5:
                    line = familyTreeView.getName();
                    list = familyTree.findAllByName(line);
                    familyTreeView.showAllInConsole(list);
                    break;
                case 6:
                    familyTreeView.showSaveTreeTitle();
                    inputOutput.saveToBin(familyTree, filePath);
                    break;
                case 7:
                    familyTreeView.showLoadTreeTitle();
                    list = inputOutput.loadFromBin(filePath);
                    familyTreeView.showAllInConsole(list);
                    break;
                // case 8:

                // break;
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
