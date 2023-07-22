package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetFamilyMemberInfo extends Command{

    public GetFamilyMemberInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о члене семьи";
    }
    @Override
    public void execute() {
        consoleUI.getFamilyMemberInfo();
    }
}
