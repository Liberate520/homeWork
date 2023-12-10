package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SetPathFile extends Commands{

    public SetPathFile(View view){
        super("Указать новый путь к файлу ", view);
    }
    public void execute() {
        getView().setPathFile();
    }
}
