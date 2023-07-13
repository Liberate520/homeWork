package family_tree.presenter;

import family_tree.model.Service;
import family_tree.model.infrastucture.Config;
import family_tree.tree.FamilyTree;
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

    public void setFamily_tree() {
        service.setFamily_tree();
    }

    public Boolean saveFamily_tree() {
        return service.saveFamily_tree();
    }

    public void getFamilyTreeInfo(String sort_by) {
        String info = service.getFamilyTreeInfo(sort_by);
        view.printAnswer(info);
    }

    public void clearFamilyTree() {
        service.clearFamilyTree();
    }

    public void set_relatives(String str) {
        service.set_relatives(str);
    }
}
