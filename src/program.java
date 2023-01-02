
import java.io.IOException;
import java.io.Serializable;

public class program implements Serializable {
        public static void main(String[] args) throws IOException, ClassNotFoundException {

                View view = new FamilyTreeUI();
                FamilyTree<Human> familyTree = new FamilyTree<>();
                Presenter presenter = new Presenter(view, familyTree);

                Human human1 = new Human("Павел", "мужской");
                familyTree.add(human1);
                Human human2 = new Human("Мария", "женский");
                familyTree.add(human2);

                Human human3 = new Human("Николай", "мужской", familyTree.getHumanByName("Павел"),
                                familyTree.getHumanByName("Мария"));
                familyTree.add(human3);

                Human human4 = new Human("Василиса", "женский", familyTree.getHumanByName("Павел"),
                                familyTree.getHumanByName("Мария"));
                familyTree.add(human4);

                Human human5 = new Human("Василий", "мужской");
                familyTree.add(human5);

                Human human6 = new Human("Елена", "женский");
                familyTree.add(human6);

                Human human7 = new Human("Андрей", "мужской", familyTree.getHumanByName("Василий"),
                                familyTree.getHumanByName("Елена"));
                familyTree.add(human7);

                Human human8 = new Human("Татьяна", "женский", familyTree.getHumanByName("Василий"),
                                familyTree.getHumanByName("Елена"));
                familyTree.add(human8);
                view.start();

        }
}
