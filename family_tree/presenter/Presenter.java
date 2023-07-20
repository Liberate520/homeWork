package family_tree.presenter;

import java.time.LocalDate;
import family_tree.model.humans.Gender;
import family_tree.model.humans.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;
   
    

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }


    public void getHumansInfo() {
        String info = service.getHumansInfo();
        view.print(info);
    }

    public void sortByYear() {
        service.sortByYear();
    }

    public  <T> void addHuman(String name, LocalDate birthDate, Gender gender) {
        T human = (T)new Human<>(name, birthDate, gender);
        service.addHuman((Human) human);
    }

}
