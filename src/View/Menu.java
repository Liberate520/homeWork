package View;

import View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public List<Option> list;

    public Menu(ViewConsole viewConsole){
        list = new ArrayList<>();
        list.add(new Exit(viewConsole));
        list.add(new AddElement(viewConsole));
        list.add(new AddChildren(viewConsole));
        list.add(new ElementInfo(viewConsole));
        list.add(new AddParent(viewConsole));
        list.add(new DeleteObject(viewConsole));
        list.add(new AllObjectInfo(viewConsole));
    }

    void execute(int choice) {
        list.get(choice).execute();
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            stringBuilder.append(i);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getSize(){
        return list.size();
    }
}
