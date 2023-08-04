import model.family_tree.TreeNode;
import model.service.Service;
import model.family_tree.FamilyTree;
import model.person.Gender;
import model.person.Person;
import model.writer.FileHandler;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
