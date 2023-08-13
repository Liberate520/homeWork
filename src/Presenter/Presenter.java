package Presenter;


import java.time.LocalDate;


import Servis.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;
    

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public  void addHuman(String name, int gender, LocalDate dataOfBirth,LocalDate  dataOfDeath ) {
        
        service.addHuman(name,gender,dataOfBirth,dataOfDeath);
    }
    public void addKinshp(int idHumanAdd,int kinship,int idHuman){
        HumanGetListInfo();
        service.addKinship(idHumanAdd, kinship, idHuman);
    }
    public void HumanGetListInfo() {
        String answer=service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        HumanGetListInfo();
    }

    public void sortById() {
        service.sortById();
        HumanGetListInfo();
    }

    public void sortByName() {
        service.sortByName();
        HumanGetListInfo();
    }

    public void saveHumanTree() {
        service.save();
    }

    public void LoadFile() {
        service.load();
        HumanGetListInfo();
    }
    public void delHuman(int id){
        service.delHuman(id);
    }
}
