package Presenter;

import UI.View;
import familyApi.Service;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void findByName(String name) {
        String info = service.findByName(name);
        view.print(info);
    }

    public void showAll() {
        String info = service.showAll();
        view.print(info);
    }
    public void addMember(String name, String gender, String dateBirth, String nameMother, String nameFather){
        try {
            service.addMember(name, gender, dateBirth, nameMother, nameFather);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void sortByName(){
        service.sortByName();
        showAll();
    }
    public void sortByDateBirth(){
        service.sortByDateBirth();
        showAll();
    }
    public void saveChanges(){
        service.saveChanges();
        view.print("Изменения сохранены");

    }
}
