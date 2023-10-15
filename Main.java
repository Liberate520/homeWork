package homeWork3;

import homeWork3.viewer.Viewer;
import homeWork3.model.FamilyTree;
import homeWork3.model.Human;
import homeWork3.model.WorkWithFile;
import homeWork3.comparator.CompareAge;
import homeWork3.ui.Console;
import homeWork3.ui.View;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        familyTree.addFamilyTree(new Human("Иван Иванов", "мужской", 22));
        familyTree.addFamilyTree(new Human("Пётр Петров", "мужской", 33));
        familyTree.addFamilyTree(new Human("Сидор Сидоров", "мужской", 44));
        familyTree.addFamilyTree(new Human("Маша Медведева", "женский", 11));

        View view = new Console();
        WorkWithFile serialize = new WorkWithFile();
        CompareAge sortAge =  new CompareAge();
        new Viewer(view, familyTree, serialize, sortAge);
        view.start();
    }
}