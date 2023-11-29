package family_tree.service;

import family_tree.family.FamilyTree;
import family_tree.human.Human;

public class Service {

    public Service() {
    }

    public String getHumanListInfo(FamilyTree tree) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список членов семьи:\n");
        for (Human human : tree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(FamilyTree tree){
        tree.sortByName();
    }

    public void sortByAge(FamilyTree tree){
        tree.sortByAge();
    }
}
