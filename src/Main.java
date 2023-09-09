import model.service.ServiceHuman;
import view.ViewHuman;

public class Main {
    public static void main(String[] args) {


//        String filePath = "testSaveObj.txt";
//        model.fileOperations.FileHandler fileHandler = new model.fileOperations.FileHandler(filePath);
//
////        fileHandler.save(tree);
//
//        model.familyTree.FamilyTree treeRead = (model.familyTree.FamilyTree) fileHandler.read();
//        System.out.println(tree.getHumanList());
        ServiceHuman s = new ServiceHuman();
//        s.testTree();
//        System.out.println(s.getHumanListInfo());
//        s.sortByName();
//        System.out.println(s.getHumanListInfo());
//        s.sortByGender();
//        System.out.println(s.getHumanListInfo());
//        s.sortByAge();
//        System.out.println(s.getHumanListInfo());

        ViewHuman v = new ViewHuman(s);
        v.run();
    }
}
