package view;

import view.commands.GetHumanList;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<GetHumanList> list;

    public Menu(Console console) {
        list = new ArrayList<>();
        list.add(new GetHumanList(console));
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
}
