package homeWorkSem1.Presenter;

import java.util.List;

import homeWorkSem1.Menu.Menu;
import homeWorkSem1.Option.*;

import homeWorkSem1.View.View;

public class Presenter {
    
    View view = new View();
    Menu menu = new Menu();
    
    public List<Option> presentMenu() {
        menu.add(new Add<>());
        menu.add(new GetTree<>());
        menu.add(new GetGrands<>());
        menu.add(new GetSisBro<>());
        menu.add(new SetFather<>());
        menu.add(new SetMother<>());
        List<Option> listOp = menu.getCommandList();
        return listOp;
    }
    
    public  void buttonClick(List<Option> listOp) {
        view.getMenu(listOp);    
    }
}
