package homeWork3;

import homeWork3.model.WorkWithFile;
import homeWork3.model.CompareAge;
import homeWork3.ui.View;

public class Viewer {
    private View view;
    private WorkWithFile serialize;
    private FamilyTree<Human> familyConnect;
    private CompareAge sortAge;

    public Viewer(View view, FamilyTree<Human> familyConnect, WorkWithFile serialize, CompareAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setViewer(this);
    }

    public void addNewHuman(String name, String sex, int age) {
        familyConnect.addFamilyTree(new Human(name, sex, age));
        view.print("Новый человек добавлен в семью");
    }

    public void printFamily() {
        String family = familyConnect.toString();
        view.print(family);
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

    public void loadFamily() {
        serialize.load("TreeFamily.txt");
    }

    public void sortFamilyByName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка по иимени завершена:");
    }

    public void sortFamilyByAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка по возрасту завершена:");
    }
}