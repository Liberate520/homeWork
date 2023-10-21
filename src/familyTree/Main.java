package familyTree;


import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Gender;
import familyTree.model.human.Human;
import familyTree.model.writer.FileHandler;
import familyTree.view.ConsoleUI;
import familyTree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}

