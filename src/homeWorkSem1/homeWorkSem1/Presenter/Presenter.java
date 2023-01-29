package homeWorkSem1.Presenter;

import java.util.List;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Menu.Menu;
import homeWorkSem1.Option.*;
import homeWorkSem1.Service.Gender;
import homeWorkSem1.View.View;

public class Presenter {
    
    View view = new View();
    Menu menu = new Menu();

    public String getInfoFromUser(String title) {
        String findByName = view.getInfo(title);
        return findByName;
    }

    public int getIntFromUser(String title) {
        int data = view.getValue(title);
        return data;
    }

    public void answerToUser(String title) {
        view.answer(title);
    }

    public Gender getGender(String title) {
        Gender gender = view.getGender(title);
        return gender;
    }
    
    public List<Option> presentMenu() {//создаем меню
        menu.add(new Add<>());
        menu.add(new GetTree());
        menu.add(new GetGrands<>());
        menu.add(new GetSisBro<>());
        menu.add(new SetFather<>());
        menu.add(new SetMother<>());
        List<Option> listOp = menu.getCommandList();
        return listOp;
    }

    public void showTree(FamilyTree<Human> tree) {
        view.showTree(tree);
    }

    
    public  void buttonClick(List<Option> listOp, FamilyTree<Human> tree) {
        listOp = menu.getCommandList();//получаем список возможных команд
        for (int index = 0; index < listOp.size(); index++) {
            view.answer(index+1 + ": " + listOp.get(index).description() + "\n");
        }
        int choice = view.getValue("Choose № of menu item");// получаем выбор пользователя
        listOp.get(choice - 1).execute(tree, new Presenter());// передаем выбор пользователя, FamilyTree и запускаем нужную программу  
    }
}
