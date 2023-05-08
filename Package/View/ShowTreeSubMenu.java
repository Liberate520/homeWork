package Package.View;

import Package.View.Commands.ShowTreeSubMenuCommands.*;

import java.util.ArrayList;
import java.util.List;

public class ShowTreeSubMenu {
    private List<SubMenuCommands> showTreeSubMenu;

    public ShowTreeSubMenu(Console console) {
        this.showTreeSubMenu = new ArrayList<>();
        showTreeSubMenu.add(new SortByName(console));
        showTreeSubMenu.add(new SortBySurname(console));
        showTreeSubMenu.add(new SortByBirthdate(console));
        showTreeSubMenu.add(new GetBackToMenu(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < showTreeSubMenu.size(); i++) {
            sb.append(i+1 + ". " + showTreeSubMenu.get(i).getDescription() + "\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return showTreeSubMenu.size();
    }

    public void execute(int choice){
        showTreeSubMenu.get(choice - 1).execute();
    }
}
