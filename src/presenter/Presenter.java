package presenter;

import familyApi.Service;
import ui.ConsoleUi;

public class Presenter {
    private ConsoleUi viev;
    private Service service;

    public Presenter(ConsoleUi viev, Service service){
        this.viev = viev;
        this.service = service;
        this.service.setPresenter(this);
        this.viev.setPresenter(this);
    }

    public String outputTree(){
        return service.getFamilyTree();
    }

    public String sortByName() {
        return service.sortFamilyTreeByName();
    }

    public String sortByBirthdate() {
        return service.sortFamilyTreeByBirthdate();
    }

    public String addNewPerson(){
        return service.addHuman();
    }

    public String findPerson() {
        return service.getByName();
    }

    public String livingHuman() {
        return service.livingHuman();
    }

    public String exit() {
        return service.exit();
    }

    public String getStringInfo(String string) {
        return viev.receiveString(string);
    }

    public int getIntInfo(String string) {
        return viev.receiveInt(string);
    }

    public void finish() {
        viev.finish();
    }
}
