package Tree.homeWork.src.Presenter;

import Tree.homeWork.src.HumanGroup.Gender;
import Tree.homeWork.src.model.Service;
import Tree.homeWork.src.ui.View;
public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }
    public void addHuman(String name, int age, int DateOfBirth, int DateOfDeath, Gender gender,
                         String father, String mother){
        service.addHuman(name, age, DateOfBirth, DateOfDeath, gender, father, mother);
    }
    public void getHumanList(){
        view.print(service.getHumanList());

    }
}
