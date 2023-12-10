package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class Exit extends Commands{

    public Exit(View view){
        super("Завершить работу ", view);
    }
    public void execute() {
        getView().endWork();}
}
