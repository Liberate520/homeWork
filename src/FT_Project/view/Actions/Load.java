package FT_Project.view.Actions;

import FT_Project.view.Console;

public class Load extends Action {
    public Load(Console console) {
        super(console);
        description = "Загрузить древо из файла";
    }

    public void execute(){
        console.load();
    }
}
