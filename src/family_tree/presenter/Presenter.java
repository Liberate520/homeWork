package family_tree.presenter;

import family_tree.model.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Presenter() {
        view = System.out::println;
        service = new Service();
    }


    public void add_human(String surname, String first_name, String patronymic, String gender, String day_birth){
        String info = service.add_human(surname, first_name, patronymic, gender, day_birth);
        view.printAnswer(info);
    }

    public void loadFamily_tree() {
        service.loadFamily_tree();
    }

    public Boolean saveFamily_tree() {
        return service.saveFamily_tree();
    }

    public void treeInfo_sortByID() {
        String info = service.treeInfo_sortByID();
        view.printAnswer(info);
    }

    public void treeInfo_sortByAge() {
        String info = service.treeInfo_sortByAge();
        view.printAnswer(info);
    }

    public void treeInfo_sortByName() {
        String info = service.treeInfo_sortByName();
        view.printAnswer(info);
    }


    public void clearFamilyTree() {
        service.clearFamilyTree();
    }


    public String send_request(String string_request) {
        return new ConsoleUI().get_reply(string_request);

    }

    public void send_info(String string) {
        view.printAnswer(string);
    }

    public void parents_finder() {
        service.parents_finder();
    }

    public void adoption() {
        service.adoption();
    }

    public void marriage() {
        service.marriage();
    }
}
