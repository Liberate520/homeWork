package presenter;
import model.service.Service;
import view.ConsoleUI;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String gender, String father, String mother, int birthdate) {
        service.addHuman(name, gender,father, mother,birthdate);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void SortByBirthdate() {
        service.SortByBirthdate();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}
