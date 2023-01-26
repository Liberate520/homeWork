package command;
import view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class Command {
    ConsoleUI view;
    String title;
    String code;
    int level = 0;
    Command parent;
    List<Command> childCommands = new ArrayList<>();

    public Command(Command parent, ConsoleUI view, String title, String code) {
        this.parent = parent;
        this.view = view;
        this.title = title;
        this.code = code;
        addChild(parent);
    }

    public Command(ConsoleUI view, String title, String code) { this(null, view, title, code);}

    public Command(ConsoleUI view, String title) { this(view, title, "");
    }

    public void addChild(Command parent) {
        if (parent != null) {
            parent.childCommands.add(this);
            level = parent.level + 1;
        }
    }

    public String getCode() {
        return code;
    }

    public String description() {
        String descr = "";

        for (int i = 0; i < level; i++)
            descr += "\t";

        if (code != "")  descr = descr + code + " - ";

        descr += title;

        for (int i = 0; i < childCommands.size(); i++)
            descr += "\n" + childCommands.get(i).description();

        return descr;
    }

    public Boolean execute(String execCode) {
        for (int i = 0; i < childCommands.size(); i++) {
            if (childCommands.get(i).execute(execCode)) return true;
        }
        return false;
    }
}
