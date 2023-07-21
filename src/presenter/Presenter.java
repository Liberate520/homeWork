package presenter;

import java.util.List;

import service.Service;
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

    public boolean addRecord(CollecterInfo collecterInfo) {
        return service.addRecord(collecterInfo);
    }

    public List<String> findRecord(String name) {
        return service.findRecord(name);
    }

    public void getRecords() {
        String answer = service.getPersonList();
        view.print(answer);
    }

    public void loadRecordsOS() {
        String answer = service.loadPersonListOS();
        view.print(answer);
    }

    public void loadRecordsTXT() {
        String answer = service.loadPersonListTXT();
        view.print(answer);
    }

    public void saveRecords() {
        String answer = service.savePersonList();
        view.print(answer);
    }

    public void sortRecordsByName() {
        service.sortRecordsByName();
    }

    public void sortRecordsById() {
        service.sortRecordsById();
    }

    public String getFileNameOS() {
        return service.getFileNameOS();
    }

    public String getFileNameTXT() {
        return service.getFileNameTXT();
    }
}
