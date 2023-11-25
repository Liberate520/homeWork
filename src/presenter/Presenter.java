package presenter;

import Animal.Human.Gender;
import service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, int year_bd, int m_bd, int day_bd, Gender gender) {
        service.addHuman(name,year_bd,m_bd,day_bd,gender);
        //какой-то ответ
        getFamalyTreeListInfo();
    }

    public void addHumanRelatives(int idHuman0, int idHuman1, int index){
        service.addHumanRelatives(idHuman0,idHuman1,index);
        getFamalyTreeListInfo();
    }

    public void getFamalyTreeListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamalyTreeListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamalyTreeListInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getFamalyTreeListInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getFamalyTreeListInfo();
    }

    public boolean saveInFile(String nameFile){
        return service.saveInFile(nameFile);
    }
}
