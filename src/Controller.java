import java.io.Serializable;
import java.util.List;

public class Controller<T extends LiveBeing<T>> {
    FamilyTree<T> familyTree;
    FamilyTreeView<T> familyTreeView;
    InputOutputList<T> inputOutput;

    public Controller(FamilyTree<T> familyTree) {
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
                    familyTreeView.EptyLineBefore();
                    list = familyTree.getLiveBeings();
                    familyTreeView.showAllInConsole(list);
                    familyTreeView.EptyLineAfter();
                    break;
                case 2:
                    familyTreeView.EptyLineBefore();
                    list = familyTree.sortByName();
                    familyTreeView.showAllInConsole(list);
                    familyTreeView.EptyLineAfter();
                    break;
                case 3:
                    familyTreeView.EptyLineBefore();
                    list = familyTree.sortByDate();
                    familyTreeView.showAllInConsole(list);
                    familyTreeView.EptyLineAfter();
                    break;
                case 4:
                    familyTreeView.EptyLineBefore();
                    line = familyTreeView.getName();
                    liveBeing = familyTree.findByName(line);
                    familyTreeView.showLiveBeing(liveBeing);
                    familyTreeView.EptyLineAfter();
                    break;
                case 5:
                    familyTreeView.EptyLineBefore();
                    line = familyTreeView.getName();
                    list = familyTree.findAllByName(line);
                    familyTreeView.showAllInConsole(list);
                    familyTreeView.EptyLineAfter();
                    break;
                // TODO
                case 6:
                    familyTreeView.EptyLineBefore();
                    familyTreeView.showSaveTreeTitle();
                    inputOutput.saveToBin(familyTree, "liveBeings.bin");
                    familyTreeView.EptyLineAfter();
                    break;
                case 7:
                    familyTreeView.EptyLineBefore();
                    familyTreeView.showLoadTreeTitle();
                    list = inputOutput.loadFromBin("liveBeings.bin");
                    familyTreeView.showAllInConsole(list);
                    familyTreeView.EptyLineAfter();
                    break;
                // END TODO
                case 8:

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
