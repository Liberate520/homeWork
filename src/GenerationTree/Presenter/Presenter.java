package GenerationTree.Presenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import GenerationTree.Model.Person.FamilyTreeService;
import GenerationTree.Model.Person.Structs.Gender;
import GenerationTree.Model.Tree.Service;
import GenerationTree.View.View;

public class Presenter {
    private View view;
    private Service tree;

    public Presenter(View view) {
        this.view = view;
        this.tree = new FamilyTreeService();
    }

    public boolean addNewTree(String surname) {
        tree = new FamilyTreeService(surname);
        view.print("Создано новое древо для семьи " + surname);
        return true;
    }

    public boolean loadTree(String surname) {
        tree.loadTree(surname);
        view.print("Древо успешно загружено.");
        return true;
    }

    public List<String> getAllTrees() {
        return tree.getAllSavedTrees();
    }

    public boolean deleteSavedTree(String name) {
        return tree.deleteSavedTree(name);
    }

    public void addNewFamilyMember(String name, Gender gender, LocalDate dateBirth) {
        try {
            tree.addTreeItem(name, gender, dateBirth);
            view.print("Член семьи " + name + " " + tree.getTreeName() + " успешно добавлен в древо.");
        } catch (RuntimeException ex) {
            view.print(ex.getMessage());
        }
    }

    public boolean saveTree(String name) {
        if (tree == null) {
            view.print("Создайте новое древо или выберите существующее.");
        }
        var result = tree.saveTree();
        if (result)
            view.print("Древо успешно сохранено в файл " + name);
        else
            view.print("Ошибка при сохранении файла...");
        return true;
    }

    public Map<Integer, String> getMembers() {
        tree.sortByName();
        return tree.getTreeItemsInfo();
    }

    public boolean saveTree() {
        return saveTree(tree.getTreeName());
    }

    public String getTreeName() {
        return tree.getTreeName();
    }

    public void loadMemberById(int menuTreeMembers) {
        view.print(tree.getItemInfoById(menuTreeMembers));
    }
}