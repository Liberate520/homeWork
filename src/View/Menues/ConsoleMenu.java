package View.Menues;

import View.Clickable;
import View.View;

import java.io.IOException;
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

    public void choose(int command) throws IOException {
        this.list.get(command).onClick();
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public void onClick() throws IOException {
        view.setLastMenu(view.getMenu());
        view.setMenu(this);
        view.callMenu();
    }

    @Override
    public String toString() {
        return menuName;
    }
}
