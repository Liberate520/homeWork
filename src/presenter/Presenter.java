package presenter;

import model.Service;
import model.human.Gender;
import model.human.Human;
import view.Console;
import view.View;

public class Presenter {
    private View view;
    private Service service;
    private Console console;
    private Human human;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addHuman(String firstName, String lastName, Gender gender) {
        String ans = service.addHuman(firstName, lastName, gender);
        view.print(ans);
    }

    public void getHumanList() {
        String ans = service.getHumanList();
        view.print(ans);
    }
    public void humanComparatorByFirstName(){ service.HumanComparatorByFirstName();    }
    public void sortByFirstName() { service.sortByFirstName();    }
    public void sortByLastName() { service.sortByLastName(); }
    public void sortById() { service.sortByID(); }
    public void searchHuman() { view.print(service.searchHuman().toString().replace("[]", "")); }
    public void sortByGender() { service.sortByGender(); }
    public void dataSave() { service.dataSave(); }

    public void getTreeInfo() {
        String ans = service.getTreeInfo();
        view.print(ans);
    }
}
