package familyTree;

import java.io.IOException;

import familyTree.model.FamilyTree;
import familyTree.model.Human;
import familyTree.model.IO;
import familyTree.model.comporator.HumanComporatorByAge;
import familyTree.presenter.Presenter;
import familyTree.ui.Console;
import familyTree.ui.View;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        // добавляем немного данных
        familyTree.addFamilyTree(new Human("Алекс", "муж", 27));
        familyTree.addFamilyTree(new Human("Владимир Владимирович Путин", "муж", 70));
        familyTree.getByName("алекс");

        // MVP 
        View view = new Console();
        IO serialize = new IO();
        HumanComporatorByAge sortAge =  new HumanComporatorByAge();
        new Presenter(view, familyTree, serialize, sortAge);
        view.start();

    }
}
