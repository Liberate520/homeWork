package homeWorkSem1;

import java.io.IOException;
import java.util.List;

import homeWorkSem1.Option.Option;
import homeWorkSem1.Presenter.Presenter;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        

        Presenter pr = new Presenter();
        FamilyTree<Human> tree = pr.createTree();//для демонстрации создаем FamilyTree
        List<Option> listOp = pr.getMenu();// показываем пользователю меню

        while (true) {
            pr.buttonClick(listOp, tree);
        }    
    }
}
