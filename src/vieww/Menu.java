package vieww;

import vieww.comands.Command;
import vieww.comands.ExitCommand;
import vieww.comands.GetHumanList;
import vieww.comands.SortByAge;
import vieww.comands.SortByName;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> list;

    public Menu(ConsoleUI console) {
        list = new ArrayList<>();
        list.add(new GetHumanList(console));
        list.add(new SortByName(console));
        list.add(new SortByAge(console));
        list.add(new ExitCommand(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(String choice){
        list.get(Integer.parseInt(choice) - 1).execute();
    }
}