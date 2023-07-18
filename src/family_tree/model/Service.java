package family_tree.model;

import family_tree.model.human.Human;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.model.registry_office.Reg_office;
import family_tree.model.registry_office.Relatives_finder;
import family_tree.model.tree.FamilyTree;
import family_tree.presenter.Presenter;

public class Service {


    private final Reg_office reg_office;

    private final File_using file_using;

    private final Relatives_finder relatives_finder;


    public Service() {
        reg_office = new Reg_office();
        file_using = new File_using();
        relatives_finder = new Relatives_finder();
    }

    public String add_human(String surname, String first_name, String patronymic, String str_gender, String str_day_birth){
        Human human = reg_office.add_human(surname, first_name, patronymic, str_gender, str_day_birth);
        if (human != null) {
            return "Добавлен новый член:\n" + human;
        } else {
            return "Что-то пошло не так";
        }
    }

    public void setFamily_tree() {
        reg_office.setFamily_tree((FamilyTree<Human>) file_using.load(Config.filePath));
    }

    public Boolean saveFamily_tree(){
        return file_using.save(reg_office.getFamily_tree(), Config.filePath);
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
        relatives_finder.parents_finder(reg_office.getFamily_tree());
    }

    public void adoption() {
        relatives_finder.adoption(reg_office.getFamily_tree());
    }

    public void marriage() {
        relatives_finder.marriage(reg_office.getFamily_tree());
    }
}
