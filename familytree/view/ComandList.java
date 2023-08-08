package familytree.view;
import java.util.ArrayList;
import java.util.List;

import familytree.view.comands.AddHuman;
import familytree.view.comands.Comand;
import familytree.view.comands.Exit;
import familytree.view.comands.PrintInfo;
import familytree.view.comands.SortByBirthdate;
import familytree.view.comands.SortBySurname;
public class ComandList {
    private List<Comand> comandList;

    public ComandList(Console console) {
        comandList = new ArrayList<>();
        comandList.add(new AddHuman(console));
        comandList.add(new PrintInfo(console));
        comandList.add(new SortByBirthdate(console));
        comandList.add(new SortBySurname(console));
        comandList.add(new Exit(console));
    }

    public String showComands() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < comandList.size(); index++) {
            stringBuilder.append(index + 1);
            stringBuilder.append(")");
            stringBuilder.append(comandList.get(index).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Comand actualCommand = comandList.get(choice - 1);
        actualCommand.execute();
    }
    
}
