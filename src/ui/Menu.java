package ui;

import java.util.ArrayList;
import ui.allMenuList.StartMenu;
import ui.allMenuList.MenuOptionable;
import ui.commands.Command;

public class Menu {
    private ArrayList<Command> commands;
    private MenuOptionable menu;
    private Console console;
    
    public Menu(Console console) {
        this.commands = new ArrayList<>();
        this.console = console;
        setMenu(new StartMenu(console));
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }
    
    public void setMenu(MenuOptionable menu) {
        this.menu = menu;
        setCommands(menu.getCommands());
    }

    public void execute(Integer num) {
        if (num > 0 && num <= commands.size()) {
            Command comand = commands.get(num - 1);
            comand.execute();
        } else System.out.println("\nВ данном меню такой команды нет.\n");
    }

    public String printMenu() {
        StringBuilder stbuild = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stbuild.append(i + 1);
            stbuild.append(". ");
            stbuild.append(commands.get(i).descriprion());
            stbuild.append("\n");
        }
        return stbuild.toString();
    }
}