package Home.ui.workWithData.Comand;

import Home.ui.workWithData.View;

public class GetHumanInfo implements Comand{
    private View view;

    public GetHumanInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Получить список людей";
    }

    @Override
    public void execute() {
        view.getHumanInfo();
    }
}
