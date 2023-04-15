package presenter;

import ui.View;

public class Presenter {
    private final View view;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void getUnitInfo(String fullName){

    }
}
