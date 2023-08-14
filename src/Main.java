import java.time.LocalDate;
import java.util.Iterator;

import Model.FamilyTree.FamilyTree;
import Model.FileHandler.FileHandler;
import Model.Human.Human;
import View.ConsoleUI;
import View.MainMenu;
import View.View;

public class Main {
public static void main(String[] args) {    
    View view = new ConsoleUI();
    view.start();
}
}