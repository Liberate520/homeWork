package presenter;
import java.io.Serializable;

import tree.Service;
import ui.View;

public class Presenter implements Serializable {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void getInfo() {
        view.print(service.getInfoHuman());
    }

    public void saveFile() {
        service.save();
    }

    public void loadFile() {
        this.service.load();
    }
}
