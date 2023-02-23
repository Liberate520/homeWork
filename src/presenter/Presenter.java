package presenter;

import familyApi.Service;
import ui.ConsoleUi;

public class Presenter {
    private ConsoleUi viev;
    private Service service;
    private boolean indicator;

    public Presenter(ConsoleUi viev, Service service){
        this.viev = viev;
        this.service = service;
        this.indicator = true;
        this.service.setPresenter(this);
    }

    public void start(){
        while (indicator) {
            int choice = viev.menu();
            switch (choice) {
                case 1:
                    viev.print(service.getFamilyTree());
                    break;
                case 2:
                    viev.print(service.sortFamilyTreeByName());
                    break;
                case 3:
                    viev.print(service.sortFamilyTreeByBirthdate());
                    break;
                case 4:
                    service.addHuman();
                    break;
                case 0:
                    viev.print(service.exit());
                    indicator = false;
                    break;
                default:
                    break;
            }
        }
    }

    public String getStringInfo(String string) {
        return viev.receiveString(string);
    }

    public int getIntInfo(String string) {
        return viev.receiveInt(string);
    }
}
