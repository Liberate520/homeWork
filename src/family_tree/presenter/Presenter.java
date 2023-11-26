package family_tree.presenter;

import family_tree.model.family_tree.service.Service;
import family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }



   public void addHuman(String snils, String fam, String name, LocalDate dr){
       service.AddHuman(snils, fam, name, dr);
       GetHumanListInfo();
    }

    public void GetHumanListInfo() {
        String answer = service.GetHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        GetHumanListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        GetHumanListInfo();
    }

    public void addMather() {
        service.AddMather();
    }

    public void AddFather() {
        service.AddFather();
    }

    public void SaveFamily() throws IOException, ClassNotFoundException {
        service.SaveFamily();
    }
    public void LoadFamily() throws IOException, ClassNotFoundException {
        service.LoadFamily();
    }
}
