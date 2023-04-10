package familyApi;

import human.Human;
import tree.FamilyTree;

public class FamilyService {
    private FamilyTree<Human> familyTree;

    public FamilyService(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public String getInfo(){
        StringBuilder info = new StringBuilder();
        for (Human member: familyTree
        ) {info.append(member.getAllInfo());
            info.append("\n");
        }
        return info.toString();
    }
    public String getInfoByName(String name){
        Human member = familyTree.getByName(name);
        if (member != null) {
            return member.getAllInfo();
        }
        return "there is no person with the given name";
    }
}
