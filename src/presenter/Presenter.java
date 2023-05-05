package presenter;

import human.Gender;
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

    public String findHumanById(int id) {
        return service
                .getHumanById(id)
                .toString();
    }

    public void findHuman(String firstName, String lastName, String birthday) {
        System.out.println(service.getHuman(firstName, lastName, birthday));
    }
}
