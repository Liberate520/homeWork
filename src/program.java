import Presenter.Presenter;
import UI.ConsoleUI;
import UI.View;
import familyApi.Service;
import human.Gender;
import human.Human;
import save.FileHandlerOut;
import tree.FamilyTree;

import java.util.Date;

public class program {
    public static void main(String[] args) throws Exception {

        FileHandlerOut fileHandlerOut = new FileHandlerOut();
        //fileHandlerOut.save(familyTree1, "familyTree.out"); // Добавили первоначльное дерево в файл
        FamilyTree familyTree = (FamilyTree) fileHandlerOut.load("familyTree.out");
  // Работа с меню
        View view = new ConsoleUI();
        Service service = new Service(familyTree);
        Presenter presenter = new Presenter(view, service);

        view.start();


    }


}
