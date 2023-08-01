package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service=new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate localDate){
        service.addHuman(name,gender,localDate);
        getHumanListInfo();

    }
    public void getHumanListInfo(){
        String info=service.getHumanInfo();
        view.printAnswer(info);
    }
}
