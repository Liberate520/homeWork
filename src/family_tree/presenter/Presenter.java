package family_tree.presenter;

import family_tree.familytree.FamilyTree;
import family_tree.familytree.FamilyTreeItem;
import family_tree.service.Service;
import family_tree.ui.View;

public class Presenter<T extends FamilyTreeItem<T>> {
    private View<T> view;
    private Service<T> service;

    public Presenter(View<T> view) {
        this.view = view;
        service = new Service<T>();
    }

    public void getInfo(String action, String data,FamilyTree<T> tree) {
        String answer = "";
        switch (action) {
            case "11" -> answer = service.getFamilyTreeShort(tree);
            case "12" -> answer = service.getFamilyTree(tree);
            case "13" -> answer = service.getUnitByName(tree);
            case "141" -> answer = service.getFamilyTreeSort(tree,"name");
            case "142" -> answer = service.getFamilyTreeSort(tree,"nameReverse");
            case "143" -> answer = service.getFamilyTreeSort(tree,"age");
            case "144" -> answer = service.getFamilyTreeSort(tree,"ageReverse");
            case "145" -> answer = service.getFamilyTreeSort(tree,"birthDate");
            case "146" -> answer = service.getFamilyTreeSort(tree,"birthDateReverse");
            case "147" -> answer = service.getFamilyTreeSort(tree,"children");
            case "148" -> answer = service.getFamilyTreeSort(tree,"childrenReverse");

            case "2" -> answer = service.getAddToTree(data, tree);

            case "3" -> answer = service.delFromTree(data, tree);

            case "4" -> answer = service.getUnitByIndex(data, tree);
            case "41", "42", "43", "44", "45", "46", "47", "48" -> answer = service.getUnitAfterChange(action, data, tree);

            case "51" -> answer = service.getPeak(tree);
            case "52" -> answer = service.getPeakByIndex(data, tree);

            case "61", "62" -> answer = service.SaveTree(action, data, tree);

            case "71", "72" -> answer = "Загружено";

            case "8" -> answer = "Дерево очищен";

            default -> answer = "ERROR - нет такого действия";
        }
        view.print(answer);
    }

    public FamilyTree<T> getTree(String action, String data) {
        if (action.equals("71") || action.equals("72")) {
            return service.getLoadTree(action, data);
        }
        return service.getNewTree();
    }
}
