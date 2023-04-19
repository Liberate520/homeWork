package presenter;

import model.FamilyService;
import model.tree.Human;
import ui.View;

public class Presenter {
    private FamilyService service;
    private View view;

    public Presenter(FamilyService service, View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public void addHuman(String name, String gender, String birthDate, String deathDate, String father, String mother) {
        String answerName = service.addHuman(name, gender, birthDate, deathDate, father, mother);
        view.print(answerName);
    }
//    public void addHuman(String name, String sex, int age) {
//        service.addHuman(new Human(name, sex, age));
//        view.print("Новый член семьи добавлен !");
//    }
    public void humanList() {
        String answerList = service.humanList();
        view.print(answerList);
    }
    public void findHuman(String name){
        String answerFind = service.findHuman(name);
        view.print(answerFind);
    }
    public void sortByName(){
        String answerSortByName = service.sortByName();
        view.print(answerSortByName);
    }

    public void sortByBirthDate(){
        String answerSortByBirthDate = service.sortByBirthDate();
        view.print(answerSortByBirthDate);
    }


}
