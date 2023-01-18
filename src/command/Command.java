package command;

import view.*;

public class Command {
    ConsoleUI view;
    String title;
    String code;
    int level = 0;

    public Command(ConsoleUI view, String title, String code, int level) {
        this.view = view;
        this.title = title;
        this.code = code;
        this.level = level;
    }

    public Command(ConsoleUI view, String title, String code) {
        this(view, title, code, 0);
    }

    public Command(ConsoleUI view, String title) {
        this(view, title, "", 0);
    }

    public String getCode() {
        return code;
    }

    public String description() {
        String descr = "";

        if (level > 0) descr += "\t";

        if (code != "")  descr = descr + code + " - ";

        descr += title;
        return descr;
    }

    public void execute() {}
}
