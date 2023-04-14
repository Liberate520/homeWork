package presenter;

import geotree.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void find(String person){
        String answer = service.findPersonByName(person);
        view.print(answer);
    }
    public void addHuman(String dataForPerson){
        String answer = service.addHuman(dataForPerson);
        view.print(answer);
    }
    public void getHuman(String person){
        String answer = service.getHuman(person);
        view.print(answer);
    }
    public void getByAge(String age){
        String answer = service.searchAge(age);
        view.print(answer);
    }
    public void getAll(){
        String answer = service.getAll();
        view.print(answer);
    }
}
