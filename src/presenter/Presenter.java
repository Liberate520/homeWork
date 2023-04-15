package presenter;

import ui.View;


public class Presenter {
    private View vew;

    public Presenter(View vew) {
        this.vew = vew;
        vew.setPresenter(this);

    }

    public void addNote(){
        System.out.println("Presenter work correct");

    }
}
