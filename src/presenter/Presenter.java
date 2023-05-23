package presenter;

import human.Gender;
import human.Human;
import service.Service;
import ui.View;

public class Presenter {
    private View viewMainMenu;
    private Service service;

    public Presenter(View viewMainMenu, Service service){
        this.viewMainMenu = viewMainMenu;
        this.service = service;
        viewMainMenu.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName, String birthday, Gender gender, int motherId, int fatherId){
        service.addHuman(firstName, lastName, birthday, gender, motherId, fatherId);
    }
    public void getPeople(){
        viewMainMenu.print(service.getPeople());
    }

    public void readFamilyTree(String fileName) throws Exception {
        service.readFamilyTreeFromFile(fileName);
    }

    public void writeFamilyTree(String family) throws Exception {
        service.writeFamilyTreeToFile(family);
    }

    public String findHumanById(int id) throws Exception{
        return service
                .getHumanById(id)
                .toString();
    }

    public String findHuman(String firstName, String lastName, String birthday) throws Exception {
        return service
                .getHuman(firstName, lastName, birthday)
                .toString();
    }
}
