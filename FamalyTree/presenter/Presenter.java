package homeWork.FamalyTree.presenter;

import java.time.LocalDate;

import homeWork.FamalyTree.model.Human.Gender;
import homeWork.FamalyTree.model.Human.Human;
import homeWork.FamalyTree.model.Service.Service;
import homeWork.FamalyTree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String last_name, LocalDate DOB, Gender gender, String father, String mother) {
        service.addHuman();
        getHumanInfo();        
    }

    public void getHumanInfo() {
        String info = service.getHumanInfo();
        view.print(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanInfo();
    }

    public void sortByName() {
        service.sortByAge();
        getHumanInfo();
    }
}
