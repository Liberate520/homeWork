package presenter;

import model.service.Service;

import model.tree.Node;
import view.View;

public class Presenter extends Service {

    private View view;
    private Service service;
    private Node tree;

    public Presenter(View view) {
        service = new Service();
        this.view = view;
        tree = new Node<>();
    }


    public String addHumans(String fullName, String gender, String age) {
        service.addHumans(fullName, gender, age);
        return getListAllHuman().toString();
    }

    public String getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
        return answer;
    }


    public String sortByName() {
        String answer = service.sortByName();
        view.print(answer);
        return answer;
    }

    public String sortByAge() {
        String answer = service.sortByAge();
        view.print(answer);
        return answer;
    }

    public String searchByName() {
        String answer = service.searchByName();
        view.print(answer);
        return answer;
    }
}




