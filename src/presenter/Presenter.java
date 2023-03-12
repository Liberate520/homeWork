package presenter;

import ui.*;

public class Presenter {

    private View view;

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(String nextLine) {
        System.out.println("работаю");
    }

}
