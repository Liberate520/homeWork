package family_tree.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import family_tree.view.commands.AddParentToChild;
import family_tree.view.commands.AddToTree;
import family_tree.view.commands.Command;
import family_tree.view.commands.GetFamilyTreeListInfo;
import family_tree.view.commands.SaveAndExit;
import family_tree.view.commands.SortByAge;
import family_tree.view.commands.SortByName;

public class MainMenu implements Serializable{
    private List<Command> commandList;

    public MainMenu(View view)
    {
        commandList = new ArrayList<>();
        commandList.add(new AddToTree(view));
        commandList.add(new GetFamilyTreeListInfo(view));
        commandList.add(new SortByName(view));
        commandList.add(new SortByAge(view));
        commandList.add(new AddParentToChild(view));
        commandList.add(new SaveAndExit(view));
    }

    public String print()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список доступных комманд:\n");
        for (int i = 0; i < commandList.size(); i++)
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public void execute(int choice)
    {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size()
    {
        return commandList.size();
    }
}
