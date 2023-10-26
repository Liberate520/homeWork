package homeWork3.core.mvp;

import homeWork3.core.models.FamilyTree;
import homeWork3.core.models.Human;
import homeWork3.core.infrastructure.CompareAge;
import homeWork3.core.models.FileStream;
import homeWork3.core.models.DataActions;

public class Presenter implements DataActions {
    public View view;
    public FileStream serialize;
    public FamilyTree<Human> familyConnect;
    private CompareAge sortAge;

    public Presenter(View view, FamilyTree<Human> familyConnect, FileStream serialize, CompareAge sortAge) {
        this.familyConnect = familyConnect;
        this.view = view;
        this.serialize = serialize;
        this.sortAge = sortAge;
        view.setPresenter(this);
    }

    @Override
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

    @Override
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

    @Override
    public void loadFamily() {
    }
}