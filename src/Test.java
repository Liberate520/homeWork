package Tree.homeWork.src;

import Tree.homeWork.src.FamilyTree;
import Tree.homeWork.src.Human;

public class Test {
    public static void main(String[] args) {
        Human human1 = new Human("Ivanov Stanislav Aleksandrovich", 33, 1990,2023, Gender.Female);
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(human1);
        human1.setName("zzzz");
        System.out.println(familyTree.getHumanList());

        Human human = new Human(null);
    }
}
