package homeWork.FamalyTree.presenter;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import homeWork.FamalyTree.model.Human.Gender;

import homeWork.FamalyTree.model.Service.Service;
import homeWork.FamalyTree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String last_name, LocalDate DOB, LocalDate DOD, Gender gender, String father, String mother, List<String> children) {
        service.addHuman(name, last_name, DOB, DOD, gender, father, mother, children);
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

    public void SaveData(File file){
        service.SaveData(null, file);
    }

    public void LoadData(File file){
        service.LoadData(null, file);
    }
}
