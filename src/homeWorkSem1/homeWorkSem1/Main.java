package homeWorkSem1;

import java.io.IOException;
import java.util.List;

import homeWorkSem1.Option.Option;
import homeWorkSem1.Presenter.Presenter;
import homeWorkSem1.Service.Gender;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //для демонстрации создаем FamilyTree
        int index=1;
        FamilyTree<Human> tree = new FamilyTree<>();
        Human human1 = new Human("Irina", 68, Gender.Female, null, null, index++);
        Human human2 = new Human("Leonid", 69, Gender.Male, null, null, index++);
        Human human3 = new Human("Liudmila", 62, Gender.Female, null, null, index++);
        Human human4 = new Human("Alexander", 65, Gender.Male,null, null, index++);
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

        Presenter pr = new Presenter();
        
        List<Option> listOp = pr.presentMenu();// показываем пользователю меню

        while (true) {
            pr.buttonClick(listOp, tree);
        }    
    }
}
