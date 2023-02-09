package homeWorkSem1.Service;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;

public class CreateTree {
    int index = 1;

    public FamilyTree<Human> createTree() {
        FamilyTree<Human> tree = new FamilyTree<>();
        Human human1 = new Human("Irina", 68, Gender.Female, null, null, index++);
        Human human2 = new Human("Leonid", 69, Gender.Male, null, null, index++);
        Human human3 = new Human("Liudmila", 62, Gender.Female, null, null, index++);
        Human human4 = new Human("Alexander", 65, Gender.Male, null, null, index++);
        Human human5 = new Human("Kate", 36, Gender.Female, human2, human1, index++);
        Human human6 = new Human("Pavel", 37, Gender.Male, human4, human3, index++);
        Human human7 = new Human("Yaroslav", 7, Gender.Male, human6, human5, index++);
        Human human8 = new Human("Sviatoslav", 3, Gender.Male, human6, human5, index++);
        tree.add(human1);
        tree.add(human2);
        tree.add(human3);
        tree.add(human4);
        tree.add(human5);
        tree.add(human6);
        tree.add(human7);
        tree.add(human8);
        return tree;
    }
}
