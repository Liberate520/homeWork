package homeWork3.viewer;

import homeWork3.model.FamilyTree;
import homeWork3.model.Human;
import homeWork3.model.WorkWithFile;
import homeWork3.comparator.CompareAge;
import homeWork3.ui.View;

public class ReView {
    private View view;
    private WorkWithFile serialize;
    private FamilyTree<Human> familyConnect;
    private CompareAge sortAge;

    public ReView(View view, FamilyTree<Human> familyConnect, WorkWithFile serialize, CompareAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setViewer(this);
    }

    public void loadFamily() {
        serialize.load("TreeFamily.txt");
    }

    public void printFamily() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void newHumanAdded(String name, String gender, int age) {
        familyConnect.addFamilyTree(new Human(name, gender, age));
        view.print("Новый человек добавлен в семью");
    }

    public void searchHuman(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Такого человека в семье нет");

        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        familyConnect.saveObject(serialize);
        view.print("Семейное древо сохранено.");
    }

    public void sortFamilyByName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка по иимени завершена, выборка готова к печати.");
    }

    public void sortFamilyByAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка по возрасту завершена, выборка готова к печати.");
    }
}