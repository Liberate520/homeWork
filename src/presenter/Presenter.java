package presenter;
import model.human.Gender;
import model.human.Human;
import view.View;
import model.service.Service;

import java.time.LocalDate;
import java.util.List;

public class Presenter {

    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
    public void addHuman(List info){
//        System.out.println(info);
//        String list = info;
//        System.out.println(list);
//        int id = Integer.parseInt(list.get(0).toString());
//        String lastname = (String) list.get(1);
//        String name = (String) list.get(2);
//        List dateBirth = List.of(list.get(3).toString().split("-"));
//        List dateDeath = List.of(list.get(4).toString().split("-"));
//        LocalDate birth = service.setDate(dateBirth, 0,1,2);
//        LocalDate death = service.setDate(dateDeath, 0,1,2);
//        Gender gender = service.setGender(list);
//        Human human = new Human(id, lastname, name, birth, death, gender);
        service.addHuman(info);
    }

    public void getHumanListInfo(){
        String answer = service.getHumanListInfo();
        view.answer(answer);
    }

    public void load(){
        service.read();

    }
    public void save(){
        service.save();


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
        Human parent = service.searchById(idParent);
        Human child = service.searchById(idChild);
        service.setChild(parent, child);

    }

    public void getId(Human human){
        service.getId(human);
    }

    @Override
    public String toString() {
        return service.getHumanListInfo();
    }
}