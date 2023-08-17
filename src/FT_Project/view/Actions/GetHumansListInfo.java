package FT_Project.view.Actions;

import FT_Project.view.Console;

public class GetHumansListInfo extends Action {
    public GetHumansListInfo(Console console) {
        super(console);
        description = "Вывести фамильное древо";
    }

    public void execute(){
        console.getHumansListInfo();
    }
} 

