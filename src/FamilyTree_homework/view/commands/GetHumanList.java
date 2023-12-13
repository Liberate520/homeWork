package FamilyTree_homework.view.commands;


import FamilyTree_homework.view.Console;

public class GetHumanList extends Command {
    private Console console;

    public GetHumanList(Console console) {
        super("Получить список семьи",console);
    }

    public String getDescription(){
        return "Получить список людей";
    }

    public void execute(){
        getConsole().getHumanList();
    }
}
