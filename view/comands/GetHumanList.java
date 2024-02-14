package view.comands;

import presenter.Presenter;
import view.Console;

public class GetHumanList extends Command {


    public GetHumanList(Console console) {
        super(console);
    }

    public String getDescription(){
        return "Получить список людей";
    }

    public void execute(){
        console.getHumanList();
    }
}