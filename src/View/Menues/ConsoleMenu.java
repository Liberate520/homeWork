package View.Menues;

import View.Clickable;
import View.View;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMenu implements Clickable{
    String menuName;
    View view;
    List<Clickable> list;

    public ConsoleMenu(String menuName, View view) {
        this.view = view;
        this.menuName = menuName;
        this.list = new ArrayList<>();
    }

    public List<Clickable> getListCommand() {
        return list;
    }

    public void choose(int command) {
        System.out.println("Действие на выбор пункта - " + command);
        this.list.get(command).onClick();
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public void onClick() {
        view.setLastMenu(view.getMenu());
        view.setMenu(this);
        view.CallMenu();
    }

    @Override
    public String toString() {
        return "Меню " + menuName;
    }
}
