package ui.menu;


import ui.View;
import ui.commands.*;

import java.util.ArrayList;


public class SimpleMenu implements Menu{
    private View view;

    private final ArrayList<ICommand> menuList;

    public SimpleMenu(View view) {
        this.view = view;
        this.menuList = new ArrayList<>();
        menuList.add(new InfoOutput(view));
        menuList.add(new AddRecord(view));
        menuList.add(new RemoveRecord(view));
        menuList.add(new ChangeRecord(view));
        menuList.add(new Exit(view));
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void execute(int num) {
        ICommand command = menuList.get(num - 1);
        command.runCommand();
    }

    @Override
    public void showMenu() {
        int num = 1;
        System.out.println();
        for (ICommand item : menuList) {
            System.out.println(num + " " + item.description());
            num += 1;
        }
    }

    @Override
    public int getMenuListSize() {
        return menuList.size();
    }
}

