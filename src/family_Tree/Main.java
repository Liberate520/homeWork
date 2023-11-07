package family_Tree;

import family_Tree.familyTree.FamilyTree;
import family_Tree.human.Gender;
import family_Tree.human.Human;
import family_Tree.service.Service;
import family_Tree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.generateTree();
        service.toPrint();
        service.sortByAge();
        service.toPrint();
    }
}
