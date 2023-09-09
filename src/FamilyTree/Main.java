package family_tree.FamilyTree;

import family_tree.FamilyTree.View.ConsoleUI;
import family_tree.FamilyTree.View.View;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        View view = new ConsoleUI();
        view.start();

    }

}
