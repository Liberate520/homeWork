package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new DataOutput(console));
        list.add(new AddHuman(console));
        list.add(new SearchHuman(console));
        list.add(new SortById(console));
        list.add(new SortByFirstName(console));
        list.add(new SortByLastName(console));
        list.add(new SortByGender(console));
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(list.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(String choice) {
        list.get(Integer.parseInt(choice) - 1).execute();
    }

    public int getSize() { return list.size();    }
}
