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
    private boolean сhangesSaved;

    public Presenter(View view) {
        this.view = view;
        this.tree = new FamilyTreeService();
        this.сhangesSaved = false;
    }

    public boolean addNewTree(String surname) {
        tree = new FamilyTreeService(surname);
        view.print("Создано новое древо для семьи " + surname);
        return true;
    }

    public boolean loadTree(String surname) {
        if (tree.loadTree(surname)) {
            view.print("Древо успешно загружено.");
            return this.сhangesSaved = true;
        }
        view.print("Загрузка древа не удалась.");
        return false;
    }

    public List<String> getAllTrees() {
        return tree.getAllSavedTrees();
    }

    public boolean getSavedState() {
        return this.сhangesSaved;
    }

    public boolean deleteSavedTree(String name) {
        return tree.deleteSavedTree(name);
    }

    public int addNewFamilyMember(String name, Gender gender, LocalDate dateBirth) {
        var id = tree.addTreeItem(name, gender, dateBirth);
        if (id >= 0) {
            view.print("Член семьи " + name + " " + tree.getTreeName() + " успешно добавлен в древо.");
            this.сhangesSaved = false;
        } else {
            throw new RuntimeException("не удалось добавить члена семьи.");
        }
        return id;
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
        this.сhangesSaved = result;
        return result;
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

    public void loadMemberById(int menuTreeMemberId) {
        if (menuTreeMemberId >= 0)
            view.print(tree.getItemInfoById(menuTreeMemberId) + "\n\n");
    }

    public void addParrent(int memberId) {
        var members = getMembers();
        members.remove(memberId);
        if (members.size() == 0)
            return;
        int parrentId = 0;
        while (parrentId >= 0) {
            parrentId = view.selectTreeMemberId(members);
            if (parrentId < 0)
                continue;
            tree.addChild(parrentId, memberId);
            view.print("Родитель добавлен.");
        }
    }

    public void delЕreeItem(int id) {
        if (tree.delTreeItem(id)) {
            view.print("Член семьи удален из всех списков.");
            this.сhangesSaved = false;
        } else
            view.print("Проблема при удалении члена семьи.");
    }
}