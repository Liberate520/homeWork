package presenter;

import service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addRecord(String name) {
        service.addRecord(name);
    }

    public void findRecord(String name) {
        service.findRecord(name);
    }

    public void getRecords() {
        String answer = service.getPersonList();
        view.print(answer);
    }

    public void loadRecords() {
        String answer = service.loadPersonList();
        view.print(answer);
    }

    public void saveRecords() {
        String answer = service.savePersonList();
        view.print(answer);
    }

    public void sortRecordsByName() {
        service.sortRecordsByName();
    }
}
