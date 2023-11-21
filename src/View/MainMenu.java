package View;

import View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List< Command > commandList;

    public MainMenu(View view) {
        commandList = new ArrayList<>();
        commandList.add(new GetInfo(view));
        commandList.add(new Load(view));
        commandList.add(new Save(view));
        commandList.add(new SortById(view));
        commandList.add(new SortByAge(view));
        commandList.add(new SortBySurname(view));
        commandList.add(new SortByName(view));
        commandList.add(new FindByName(view));
        commandList.add(new AddHuman(view));
        commandList.add(new SetChild(view));
        commandList.add(new Finish(view));
    }
    public String print(){
        StringBuilder builder = new StringBuilder();
        builder.append("Список команд:\n");
        for (int i=0; i<commandList.size();i++){
            builder.append(i+1);
            builder.append(". ");
            builder.append(commandList.get(i).getDescription());
            builder.append("\n");
        }
        return builder.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }
    public int size(){
        return commandList.size();
    }
}
