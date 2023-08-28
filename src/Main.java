import familyTree.FamilyTree;
import human.Gender;
import human.Human;
import service.Service;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();


//        String filePath = "testSaveObj.txt";
//        fileOperations.FileHandler fileHandler = new fileOperations.FileHandler(filePath);
//
////        fileHandler.save(tree);
//
//        familyTree.FamilyTree treeRead = (familyTree.FamilyTree) fileHandler.read();
//        System.out.println(tree.getHumanList());
        Service s = new Service(tree);
        System.out.println(s.getHumanListInfo());
        s.sortByName();
        System.out.println(s.getHumanListInfo());

    }


    static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();
        Service treeService = new Service(tree);

        Human marya = new Human("Мария", Gender.FEMALE,"2000-03-12");
        Human prohor = new Human("Прохор",Gender.MALE, "1999-06-21");
        treeService.addHuman(marya);
        treeService.addHuman(prohor);
        treeService.setWedding(marya,prohor);

        Human boris = new Human("Борис",Gender.MALE,
                "2018-07-23", marya,prohor);
        Human olesia = new Human("Олеся",Gender.FEMALE,
                "2020-12-05", marya,prohor);
        treeService.addHuman(boris);
        treeService.addHuman(olesia);

        Human pavel = new Human("Павел",Gender.MALE,"1968-07-23");
        pavel.addChild(prohor);
        treeService.addHuman(pavel);

        return tree;
    }
}
