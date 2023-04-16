package View;

import View.Comands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> list;
    private Console console;
    public Menu(Console console) {
        this.console = console;
        list = new ArrayList<>();
        list.add(new AddHuman(console));
        list.add(new GetHumanList(console));
        list.add(new SortByName(console));
        list.add(new SortByBirthday(console));
        list.add(new Exit(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int num){
        Option option = list.get(num-1);
        option.execute();
    }
    public int getSize(){
        return list.size();
    }
}
