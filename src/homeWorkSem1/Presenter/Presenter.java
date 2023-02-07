package homeWorkSem1.Presenter;

import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Menu.Menu;
import homeWorkSem1.Option.*;
import homeWorkSem1.Service.CreateTree;
import homeWorkSem1.View.View;

public class Presenter {
    
    View view = new View();
    Menu menu = new Menu();
    CreateTree newTree = new CreateTree();


    public List<Option> getMenu(){
        return menu.presentMenu();
    }

    public FamilyTree<Human> createTree() {
        return newTree.createTree();
    }

    
    public  void buttonClick(List<Option> listOp, FamilyTree<Human> tree) {
        listOp = menu.getCommandList();//получаем список возможных команд
        for (int index = 0; index < listOp.size(); index++) {
            view.answer(index+1 + ": " + listOp.get(index).description() + "\n");
        }
        int choice = view.getValue("Choose № of menu item");// получаем выбор пользователя
        listOp.get(choice - 1).exucute(tree);// передаем выбор пользователя, FamilyTree и запускаем нужную программу  
    }
}
