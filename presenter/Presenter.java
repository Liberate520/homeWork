package presenter;

import model.service.Service;

import view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Presenter {

    private View view;
    private Service service;


    public Presenter(View view) {
        service = new Service();
        this.view = view;


    }


    public String addHumans(String fullName, String gender, String age) {
        service.addHumans(fullName, gender, age);
        return service.getHumanList().toString();
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

    public String searchByName(String name) {
        String answer = service.searchByName(name);
        view.print(answer);
        return answer;
    }

    public void familyNode(String parent, String children) {
        ArrayList answer = service.familyNode(parent, children);
        view.print(String.valueOf(answer));


    }

    public String familyCollection() {
        String answer = service.familyСollection();
        view.print(String.valueOf(answer));
        return answer;

    }

    public String familyTreeEntry(String path) {
        String answer = String.valueOf(service.familyTreeEntry(path));
        view.print(String.valueOf(answer));
        return answer;

    }

    public String familyTreeRead(String path) {
        String answer = String.valueOf(service.familyTreeRead(path));
        view.print(String.valueOf(answer));
        return answer;

    }
}




