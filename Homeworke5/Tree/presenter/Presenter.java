package presenter;

import java.util.List;

import model.*;
import ui.View;

public class Presenter {
    FileHandler fileHandler = new FileHandler();
    FamilyTree tree = new FamilyTree();

    public FamilyTree addTree(FamilyTree tree) {
        this.tree = tree;
        tree.add(new Human("Sergey Petrov", 1965));    // Имя: Sergey Petrov, date birth: 1965, мать: неизвестна, отец: неизвестен, дети: Anfisa Ivanova
        tree.add(new Human("Lidiya Petrova", 1966));   // Имя: Lidiya Petrova, date birth: 1966, мать: неизвестна, отец: неизвестен, дети: Anfisa Ivanova
        tree.add(new Human("Evgeniy Ivanov", 1967));   // Имя: Evgeniy Ivanov, date birth: 1967, мать: неизвестна, отец: неизвестен, дети: Grigoriy Ivanov
        tree.add(new Human("Nina Ivanova", 1968));     // Имя: Nina Ivanova, date birth: 1968, мать: неизвестна, отец: неизвестен, дети: Grigoriy Ivanov
        tree.add(new Human("Anfisa Ivanova", 1990, tree.getByName("Sergey Petrov"), tree.getByName("Lidiya Petrova")));  // Имя: Anfisa Ivanova, date birth: 1990, мать: Lidiya Petrova, отец: Sergey Petrov, дети: Ivan Ivanov, Semen Ivanov
        tree.add(new Human("Grigoriy Ivanov", 1991, tree.getByName("Evgeniy Ivanov"), tree.getByName("Nina Ivanova")));  // Имя: Grigoriy Ivanov, date birth: 1991, мать: Nina Ivanova, отец: Evgeniy Ivanov, дети: Ivan Ivanov, Semen Ivanov
        tree.add(new Human("Ivan Ivanov", 1992, tree.getByName("Grigoriy Ivanov"), tree.getByName("Anfisa Ivanova")));   // Имя: Ivan Ivanov, date birth: 1992, мать: Anfisa Ivanova, отец: Grigoriy Ivanov, дети: отсутствуют
        tree.add(new Human("Semen Ivanov", 1993, tree.getByName("Grigoriy Ivanov"), tree.getByName("Anfisa Ivanova")));  // Имя: Semen Ivanov, date birth: 1993, мать: Anfisa Ivanova, отец: Grigoriy Ivanov, дети: отсутствуют
        return tree;
    }

    
    //     fileHandler.read();
    //     int num = -1;
    //     while (num != 0) {
    //         num = v.menu();
    //         switch (num) {
    //             case 1 -> System.out.println(tree.toString());
    //             case 2 -> tree.sortByName();
    //             case 3 -> tree.sortByAge();
    //             case 4 -> tree.searchByName();
    //             case 5 -> tree.add(tree.addNewHuman());
    //             case 6 -> fileHandler.save(tree);
    //             case 0 -> System.out.println("      *** Closed ***      ");
    //         }
    //     }
    // }
    
    private View view;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(String nextLine) {
        tree.add(tree.addNewHuman());
    }

    public void printList() {
        System.out.println(tree.toString());

    }
}

