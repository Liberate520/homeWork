package presenter;

import service.Service;
import view.Dispatcher;
import view.View;

public class Presenter {

    private final View view;

    public void setService(Service service) {
        this.service = service;
    }

    private Service service;

    public Presenter(Dispatcher dispatcher){
        this.view = dispatcher;
    }

    public void getCommand(String command){
        service.receive(command);
    }
    public void toPrint(String data){
        view.print(data);
    }
}
