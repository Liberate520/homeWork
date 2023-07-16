package family_tree.model;

import family_tree.model.human.Human;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.model.registry_office.Reg_office;
import family_tree.model.registry_office.Relatives_finder;
import family_tree.model.tree.FamilyTree;
import family_tree.model.tree.tree_service.Tree_service;

public class Service {


    private Reg_office reg_office;
    private Date_using date_using;
    private File_using file_using;
    private Tree_service tree_service;
    private Relatives_finder relatives_finder;

    public Service() {
        reg_office = new Reg_office();
        date_using = new Date_using();
        file_using = new File_using();
        tree_service = new Tree_service();
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

    public String getFamilyTreeInfo(String sort_by) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (sort_by) {
            case "2" -> stringBuilder.append(tree_service.sortByName(reg_office.getFamily_tree()));
            case "3" -> stringBuilder.append(tree_service.sortByAge(reg_office.getFamily_tree()));
            default -> stringBuilder.append(tree_service.sortById(reg_office.getFamily_tree()));
        }
        return stringBuilder.toString();
    }

    public void clearFamilyTree() {
        reg_office.getFamily_tree().clearHumanList();
    }

    public void set_relatives(String str){
        relatives_finder.set_relatives(str, reg_office.getFamily_tree());
    }


}
