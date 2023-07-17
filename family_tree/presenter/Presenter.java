package family_tree.presenter;

import java.time.LocalDate;
import family_tree.model.humans.Gender;
import family_tree.model.humans.Human;
import family_tree.model.service.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;
    private Human human;
    

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Presenter(ConsoleUI consoleUI) {

    }

    public void getHumansInfo() {
        String info = service.getHumansInfo();
        view.print(info);
    }

    public void sortByYear() {
        service.sortByYear();
    }

    public  void addHuman(String name, LocalDate birthDate, Gender gender) {
        service.addHuman(human);
    }

}
