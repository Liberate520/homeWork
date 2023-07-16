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
        view = new View() {
            @Override
            public void printAnswer(String text) {
                System.out.println(text);
            }
        };
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

    public String send_request(String string_request) {
        return new ConsoleUI().get_reply(string_request);

    }

    public void send_info(String string) {
        view.printAnswer(string);
    }
}
