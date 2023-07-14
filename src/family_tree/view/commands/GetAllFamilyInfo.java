package family_tree.view.commands;

import family_tree.view.Console;

public class GetAllFamilyInfo extends Command{
    public GetAllFamilyInfo(Console console) {
        super(console);
        description = "Получить информацию о родственных связах конкретного члена древа.";
    }

    public void execute(){
        console.viewAllFamilyInfo();
    }
}
