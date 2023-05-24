package Home.ui.workWithData.Comand;

import Home.ui.workWithData.View;

public class Stop implements Comand{
    private View view;

    public Stop(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute() {
        view.finish();
    }
}
