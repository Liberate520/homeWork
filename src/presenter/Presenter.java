package presenter;

import service.Service;
import view.View;

public class Presenter {

    private final View view;
    private Service service;

    public void setService(Service service) {
        this.service = service;
    }


    public Presenter(View dispatcher) {
        this.view = dispatcher;
    }

    public void getCommand(String command) {
        service.receive(command);
    }

    public void toPrint(String data) {
        view.print(data);
    }
}
