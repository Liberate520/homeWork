package presenter;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.writer.Writable;
import view.View;
import model.service.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Presenter {

    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        Writable writable = new FileHandler<Human>();
        service = new Service(writable);
    }
    public void addHuman(List info){
        service.addHuman(info);
    }

    public void getHumanListInfo(){
        String answer = service.getHumanListInfo();
        view.answer(answer);
    }

    public void load(){
        service.read();
    }
    public boolean save(){
        return service.save();
    }

    public void sortByAge(){
        service.sortByAge();

    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortBySurname(){
        service.sortByLastname();

    }
    public void sortById(){
        service.sortById();
    }

    public String searchByName(String name){
        return service.searchByNameSurname(name);
    }

    public void setChild(int idParent,int  idChild){
        service.setChild(idParent, idChild);
    }

    public void getId(Human human){
        service.getId(human);
    }

    @Override
    public String toString() {
        return service.getHumanListInfo();
    }
}