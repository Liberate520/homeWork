package familyTree.presenter;

import familyTree.model.FamilyTree;
import familyTree.model.Human;
import familyTree.model.IO;
import familyTree.model.comporator.HumanComporatorByAge;
import familyTree.ui.View;

public class Presenter {
    private View view;
    private IO serialize;
    private FamilyTree<Human> familyConnect;
    private HumanComporatorByAge sortAge;

    public Presenter(View view, FamilyTree<Human> familyConnect, IO serialize, HumanComporatorByAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    public void addHumanNew(String name, String sex, int age) {
        familyConnect.addFamilyTree(new Human(name, sex, age));
        view.print("Новый член семьи добавлен !");
    }

    public void familyPrint() {
        String family = familyConnect.toString();
        view.print(family);
    }

    public void humanSearch(String name) {
        Human human = familyConnect.getByName(name);
        if (human == null)
            view.print("Такого человека нет в семье !");

        else {
            String foundHuman = human.toString();
            view.print(foundHuman);
        }
    }

    public void saveFamily() {
        familyConnect.saveObj(serialize);
        view.print("Семейное древо сохранено !");
    }

    public void loadFamily() {
        serialize.load("TreeFamily.data");
    }

    public void sortFamilyName() {
        familyConnect.getFamilyTree().sort(null);
        view.print("Сортировка завершена !");
    }

    public void sortFamilyAge() {
        familyConnect.getFamilyTree().sort(sortAge);
        view.print("Сортировка завершена !");
    }
}
