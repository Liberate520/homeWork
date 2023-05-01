package presenter;

import model.service.Service;
import view.CollecterInfo;
import view.View;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addRecord(CollecterInfo collecterInfo) {
        service.addRecord(collecterInfo);
    }

    public void findRecord(String name) {
        service.findRecord(name);
    }
    public void getRecords() {
        String answer = service.getHumanList();
        view.print(answer);
    }

    public void loadRecordsOS() {
        String answer = service.loadHumanListOS();
        view.print(answer);
    }

    public void loadRecordsTXT() {
        String answer = service.loadHumanListTXT();
        view.print(answer);
    }

    public void saveRecords() {
        String answer = service.saveHumanList();
        view.print(answer);
    }
    public void sortRecordsByName() {
        service.sortRecordsByName();
    }

    public void sortRecordsById() {
        service.sortRecordsById();
    }
}
