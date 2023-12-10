package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SetDathday extends Commands{

    public SetDathday(View view){
        super("Установить дату смерти ", view);
    }
    public void execute() {
        getView().setDathday();
    }
}
