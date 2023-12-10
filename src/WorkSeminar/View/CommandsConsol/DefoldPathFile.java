package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class DefoldPathFile extends Commands{

    public DefoldPathFile(View view){
        super("Установить путь для файла по умолчанию ", view);
    }
    public void execute() {
        getView().defoldPathFile();
    }
}
