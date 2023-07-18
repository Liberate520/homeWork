package family_tree.model;

import family_tree.model.human.Human;
import family_tree.model.registry_office.Reg_office;
import family_tree.presenter.Presenter;

public class Service {


    private final Reg_office reg_office;



    public Service() {
        reg_office = new Reg_office();
    }

    public String add_human(String surname, String first_name, String patronymic, String str_gender, String str_day_birth){
        Human human = reg_office.add_human(surname, first_name, patronymic, str_gender, str_day_birth);
        if (human != null) {
            return "Добавлен новый член:\n" + human;
        } else {
            return "Что-то пошло не так";
        }
    }

    public void loadFamily_tree() {
        reg_office.loadFamily_tree();
    }

    public Boolean saveFamily_tree(){
        return reg_office.saveFamily_tree();
    }

    public String treeInfo_sortByID() {
        return reg_office.treeInfo_sortByID();
    }

    public String treeInfo_sortByAge() {
        return reg_office.treeInfo_sortByAge();
    }

    public String treeInfo_sortByName() {
        return reg_office.treeInfo_sortByName();
    }
    public void clearFamilyTree() {
        reg_office.getFamily_tree().clearHumanList();
    }


    public String send_request(String string_request) {
        return new Presenter().send_request(string_request);
    }

    public void send_info(String string) {
        new Presenter().send_info(string);
    }

    public void parents_finder() {
        reg_office.parents_finder();
    }

    public void adoption() {
        reg_office.adoption();
    }

    public void marriage() {
        reg_office.marriage();
    }
}
