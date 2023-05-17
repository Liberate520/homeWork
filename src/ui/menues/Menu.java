package java_oop_homeWork.src.ui.menues;

import java_oop_homeWork.src.ui.View;
import java_oop_homeWork.src.ui.commands.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public abstract class Menu {
    protected List<Command> commandList;
    public String error;

    private View view;
    public Menu(View view) {
        this.commandList = new ArrayList<>();
        this.error = null;
        this.view = view;
    }

    public String Show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void execute(int numCommand) {
        try {
            commandList.get(numCommand - 1).execute();
        }
        catch (IndexOutOfBoundsException e) {
            view.errorSelectMenu("Введите значение соответствующее пункту меню");
        }
    }
}
