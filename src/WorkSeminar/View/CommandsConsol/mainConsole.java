package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

import java.util.ArrayList;
import java.util.List;

public class mainConsole {
    private List<Commands> commandList;
    /*
    Учитывая что лист команд значительно разросся, имеет смысл подумать о создании подменю,
    разбив команды на категории. Но это уже как-нибудь потом.
     */
    public mainConsole(View view){
        commandList = new ArrayList<>();
        commandList.add(new CreateTree(view));
        commandList.add(new ShowTree(view));
        commandList.add(new GetNamePersona(view));
        commandList.add(new SaveTree(view));
        commandList.add(new LoadTree(view));
        commandList.add(new SortTreeByName(view));
        commandList.add(new SortDefaut(view));
        commandList.add(new SortThreeByAge(view));
        commandList.add(new SortTreeByGender(view));
        commandList.add(new CreatPersona(view));
        commandList.add(new SetWedding(view));
        commandList.add(new AddParent(view));
        commandList.add(new AddKid(view));
        commandList.add(new SetDathday(view));
        commandList.add(new GetSisBroth(view));
        commandList.add(new GetPathFile(view));
        commandList.add(new DefoldPathFile(view));
        commandList.add(new SetPathFile(view));
        commandList.add(new Exit(view));

    }
    public  String print(){
        StringBuilder printCommand = new StringBuilder();
        printCommand.append("Command: ");
        printCommand.append("\n");
        for(int i = 0; i < commandList.size(); i++){
            printCommand.append(i+1);
            printCommand.append(". ");
            printCommand.append(commandList.get(i).getDescription());
            printCommand.append("\n");
        }
        return printCommand.toString();
    }
    public  void  execute(int commandNumber){
        Commands command = commandList.get(commandNumber - 1);
        command.execute();
    }

    public  int size(){
        return  commandList.size();
    }
}
