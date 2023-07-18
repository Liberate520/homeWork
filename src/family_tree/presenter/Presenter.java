package family_tree.presenter;

import family_tree.model.registry_office.Reg_office;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Presenter {
    private final View view;
    private final Reg_office reg_office;

    public Presenter(View view) {
        this.view = view;
        reg_office = new Reg_office();
    }

    public Presenter() {
        view = System.out::println;
        reg_office = new Reg_office();
    }


    public void add_human(String surname, String first_name, String patronymic, String gender, String day_birth){
        String info = reg_office.add_human(surname, first_name, patronymic, gender, day_birth);
        view.printAnswer(info);
    }

    public void loadFamily_tree() {
        reg_office.loadFamily_tree();
    }

    public Boolean saveFamily_tree() {
        return reg_office.saveFamily_tree();
    }

    public void treeInfo_sortByID() {
        String info = reg_office.treeInfo_sortByID();
        view.printAnswer(info);
    }

    public void treeInfo_sortByAge() {
        String info = reg_office.treeInfo_sortByAge();
        view.printAnswer(info);
    }

    public void treeInfo_sortByName() {
        String info = reg_office.treeInfo_sortByName();
        view.printAnswer(info);
    }


    public void clearFamilyTree() {
        reg_office.getFamily_tree().clearHumanList();
    }


    public String send_request(String string_request) {
        return new ConsoleUI().get_reply(string_request);

    }

    public void send_info(String string) {
        view.printAnswer(string);
    }

    public void parents_finder() {
        reg_office.parents_finder();
    }

    public void adoption() {
        reg_office.adoption();
    }

    public void marriage() {
        reg_office.marriage();
    }
}
