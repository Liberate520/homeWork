package Home.ui.workWithData.Comand;

import Home.ui.workWithData.DataHuman;
import Home.ui.workWithData.View;
import Home.ui.workWithData.WorkWithData;

public class AddHuman extends DataHuman implements Comand{

    private View view;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
         view.addHuman();
    }
}
