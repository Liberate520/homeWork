package ui;

import ui.Commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;
    private View view;

    public Menu(View view){
        commandList= new ArrayList<>();
        commandList.add(new PrintTree(view));
        commandList.add(new SaveTree(view));
        commandList.add(new LoadTree(view));
        commandList.add(new SortBySecondName(view));
        commandList.add(new SortBySex(view));
        commandList.add(new sortByBirthYear(view));
        commandList.add(new Finish(view));
    }
    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }

        return sb.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        commandList.get(choice - 1).execute();
    }

    public int size(){
        return commandList.size();
    }

}
