package family_tree.presenter;

import family_tree.model.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void add_human(String surname, String first_name, String patronymic, String gender, String day_birth){
        String info = service.add_human(surname, first_name, patronymic, gender, day_birth);
        view.printAnswer(info);
    }

}
