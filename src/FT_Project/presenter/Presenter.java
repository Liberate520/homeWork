package FT_Project.presenter;



import java.time.LocalDate;

import FT_Project.model.Human.Gender;
import FT_Project.model.service.Service;
import FT_Project.view.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addHuman(String name, String gender, LocalDate birthDate){
        service.addHuman(name, gender, birthDate);
        getHumansListInfo();
    }

    public void addChildToParents(long id1, long id2, long id3){
        service.addChildToParents(id1, id2, id3);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }
    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }
    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }
    public void sortById() {
        service.sortById();
        getHumansListInfo();
    }
    public void remove(long id) {
        service.remove(id);
        getHumansListInfo();
    }
    public void setWedding(long id1, long id2) {
        service.setWedding(id1, id2);
        getHumansListInfo();
    }
    public void setDivorce(long id1, long id2) {
        service.setDivorce(id1, id2);
        getHumansListInfo();
    }
    public void load(){
        service.load();
    }
    public void save(){
        service.save();
    }
}
