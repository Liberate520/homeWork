package presenter;

import ui.View;
import api.Service;

import java.io.IOException;

public class Presenter
{
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void onClick(String stringMenuNumber) throws IOException, ClassNotFoundException {
        String answer = service.get(stringMenuNumber);
        view.print(answer);
    }
}
