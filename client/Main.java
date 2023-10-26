package homeWork3.client;

import homeWork3.core.mvp.Presenter;
import homeWork3.core.models.FamilyTree;
import homeWork3.core.models.Human;
import homeWork3.core.models.FileStream;
import homeWork3.core.infrastructure.CompareAge;
import homeWork3.ui.Console;
import homeWork3.core.mvp.View;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        familyTree.addFamilyTree(new Human("Иван Иванов", "мужской", 22));
        familyTree.addFamilyTree(new Human("Пётр Петров", "мужской", 33));
        familyTree.addFamilyTree(new Human("Сидор Сидоров", "мужской", 44));
        familyTree.addFamilyTree(new Human("Маша Медведева", "женский", 11));

        View view = new Console();
        FileStream serialize = new FileStream();
        CompareAge sortAge =  new CompareAge();
        new Presenter(view, familyTree, serialize, sortAge);
        view.start();
    }
}