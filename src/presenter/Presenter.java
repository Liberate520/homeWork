package presenter;

import model.human.Human;
import model.service.ServiceHuman;
import view.ConsoleUI;

public class Presenter {
    private ConsoleUI view;
    private ServiceHuman service;

    public Presenter(ConsoleUI view) {
        this.view = view;
        this.service = new ServiceHuman();
    }

    public void addTreeItem(Human item){
        service.addTreeItem(item);
    }
    public Human getById(long id){
        return service.getById(id);
    }
    public void remove(long id){
        service.remove(id);
    }

    public String getHumanListInfo(){
        return service.getHumanListInfo();
    }
}
