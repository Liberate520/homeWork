package FT_Project.view.Actions;

import FT_Project.view.Console;

public class Save extends Action{
    public Save(Console console) {
        super(console);
        description = "Сохранить древо в файл";
    }

    public void execute(){
        console.save();
    }
}
