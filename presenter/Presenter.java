package presenter;

import model.service.Service;

import model.tree.Node;
import model.tree.relative.Relative;
import view.View;

public class Presenter {

    private View view;
    private Service service;


    public Presenter(View view) {
        service = new Service();
        this.view = view;


    }


    public String addHumans(String fullName, String gender, String age) {
        service.addHumans(fullName, gender, age);
        return service.getListAllHuman().toString();
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

    public void familyNode(String parent, String children) {
        String answer = String.valueOf(service.familyNode(parent, children));
        view.print(String.valueOf(answer));


    }

    public String familyCollection(String person, String rel) {
        String answer = service.familyСollection(person.toString(), rel);
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




