import FamalyTree.FamilyTree;
import FamalyTree.Gender;
import FamalyTree.Human;
import SaveAs.*;

public class Main {
    public static void main(String[] args){
        String path = "tree.txt";
        FileManager fm = new FileManager();
        FamilyTree familyTree = new FamilyTree();
        Human ivan = new Human(Gender.Male, "Ivan", "Ivanov", null, null);
        Human olga = new Human(Gender.Female, "Olga", "Ivanova", null, null);
        familyTree.addMember(ivan);
        familyTree.getMarried(ivan, olga);
        Human masha = new Human(Gender.Female, "Masha");
        familyTree.addChild(ivan, masha);
        Human kolya = new Human(Gender.Male, "Kolya");
        familyTree.addChild(olga, kolya);
        Human sergey = new Human(Gender.Male, "Sergey", "Sergeev", null, null);
        familyTree.getMarried(masha, sergey);
        familyTree.getInfo();
        fm.save(familyTree, path);
//        FamilyTree newFamilyTree = fm.upload(path);
//        newFamilyTree.getInfo();
    }
}
