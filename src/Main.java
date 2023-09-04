import familyTree.FamilyTree;
import human.Gender;
import human.Human;
import service.Service;
import view.View;

public class Main {
    public static void main(String[] args) {


//        String filePath = "testSaveObj.txt";
//        fileOperations.FileHandler fileHandler = new fileOperations.FileHandler(filePath);
//
////        fileHandler.save(tree);
//
//        familyTree.FamilyTree treeRead = (familyTree.FamilyTree) fileHandler.read();
//        System.out.println(tree.getHumanList());
        Service s = new Service();
//        s.testTree();
//        System.out.println(s.getHumanListInfo());
//        s.sortByName();
//        System.out.println(s.getHumanListInfo());
//        s.sortByGender();
//        System.out.println(s.getHumanListInfo());
//        s.sortByAge();
//        System.out.println(s.getHumanListInfo());

        View v = new View(s);
        v.run();
    }
}
