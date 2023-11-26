package family_tree.view;

import family_tree.view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Commands> commandsList;

    public MainMenu(View view) {
        this.commandsList = new ArrayList<>();
        commandsList.add(new AddHuman(view));
        commandsList.add(new GetHumanListInfo(view));
        commandsList.add(new sortByName(view));
        commandsList.add(new sortByAge(view));
        commandsList.add(new AddMather(view));
        commandsList.add(new AddFather(view));
        commandsList.add(new SaveFamily(view));
        commandsList.add(new LoadFamily(view));
        commandsList.add(new Finish(view));

    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список команд: \n" );
        for (int i = 0; i < commandsList.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Commands commands = commandsList.get(choice-1);
        commands.execute();
    }

    public int size(){
        return commandsList.size();
    }
}
