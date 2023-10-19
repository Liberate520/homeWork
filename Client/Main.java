package homeWork3.Client;

import homeWork3.Core.MVP.Presenter;
import homeWork3.Core.Models.FamilyTree;
import homeWork3.Core.Models.Human;
import homeWork3.Core.MVP.Model;
import homeWork3.Core.Infrastructure.CompareAge;
import homeWork3.UI.Console;
import homeWork3.Core.MVP.View;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        familyTree.addFamilyTree(new Human("Иван Иванов", "мужской", 22));
        familyTree.addFamilyTree(new Human("Пётр Петров", "мужской", 33));
        familyTree.addFamilyTree(new Human("Сидор Сидоров", "мужской", 44));
        familyTree.addFamilyTree(new Human("Маша Медведева", "женский", 11));

        View view = new Console();
        Model serialize = new Model();
        CompareAge sortAge =  new CompareAge();
        new Presenter(view, familyTree, serialize, sortAge);
        view.start();
    }
}