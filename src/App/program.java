package App;

import java.io.IOException;
import java.io.Serializable;

import Interface.View;
import Model.FamilyTree;
import Model.FamilyTreeOperator;
import Interface.FamilyTreeUI;
import Model.Human;

public class program implements Serializable {
        public static void main(String[] args) throws IOException, ClassNotFoundException {

                View view = new FamilyTreeUI();
                FamilyTree<Human> familyTree = new FamilyTree<>();
                FamilyTreeOperator familyTreeOperator = new FamilyTreeOperator(familyTree);
                Presenter presenter = new Presenter(view, familyTree, familyTreeOperator);

                Human human1 = new Human("Павел", "мужской");
                familyTreeOperator.add(human1);

                Human human2 = new Human("Мария", "женский");
                familyTreeOperator.add(human2);

                Human human3 = new Human("Николай", "мужской", familyTree.getHumanByName("Павел"),
                                familyTree.getHumanByName("Мария"));
                familyTreeOperator.add(human3);

                Human human4 = new Human("Василиса", "женский", familyTree.getHumanByName("Павел"),
                                familyTree.getHumanByName("Мария"));
                familyTreeOperator.add(human4);

                Human human5 = new Human("Василий", "мужской");
                familyTreeOperator.add(human5);

                Human human6 = new Human("Елена", "женский");
                familyTreeOperator.add(human6);

                Human human7 = new Human("Андрей", "мужской", familyTree.getHumanByName("Василий"),
                                familyTree.getHumanByName("Елена"));
                familyTreeOperator.add(human7);

                Human human8 = new Human("Татьяна", "женский", familyTree.getHumanByName("Василий"),
                                familyTree.getHumanByName("Елена"));
                familyTreeOperator.add(human8);

                view.start();

        }
}
