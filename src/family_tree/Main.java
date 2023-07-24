package family_tree;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.E;
import family_tree.model.writer.FileHandler;
import family_tree.view.ConsoleUi;
import family_tree.view.View;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUi();
        view.start();
    }

}
