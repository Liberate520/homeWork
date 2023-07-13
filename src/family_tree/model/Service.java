package family_tree.model;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.model.registry_office.Reg_office;
import family_tree.model.registry_office.relation.Relatives_finder;
import family_tree.model.tree.FamilyTree;
import family_tree.model.tree.tree_service.Tree_service;


import java.time.LocalDate;

public class Service {

    public Reg_office reg_office;
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
        Gender gender = reg_office.tryGender(str_gender);
        LocalDate day_birth = date_using.tryLocalDate(str_day_birth);
        Human human = reg_office.add_human(surname, first_name, patronymic, gender, day_birth);
        if (human != null) {
            return "Добавлен новый член:\n" + human;
        } else {
            return "Что-то пошло не так";
        }
    }


    public void setFamily_tree() {
        reg_office.setFamily_tree((FamilyTree) file_using.load(Config.filePath));
    }

    public Boolean saveFamily_tree(){
        return file_using.save(reg_office.family_tree, Config.filePath);
    }

    public String getFamilyTreeInfo(String sort_by) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (sort_by){
            case "2":
                stringBuilder.append(tree_service.sortByName(reg_office.family_tree));
                break;
            case "3":
                stringBuilder.append(tree_service.sortByAge(reg_office.family_tree));
                break;
            default:
                stringBuilder.append(tree_service.sortById(reg_office.family_tree));
        }
        return stringBuilder.toString();
    }

    public void clearFamilyTree() {
        reg_office.family_tree.clearHumanList();
    }

    public void set_relatives(String str){
        if (str.equals("1")) {
            reg_office.family_tree = relatives_finder.parents_finder(reg_office.family_tree);
        }
        if (str.equals("2")) {
            reg_office.family_tree = relatives_finder.adoption(reg_office.family_tree);
        }
        if (str.equals("3")) {
            reg_office.family_tree = relatives_finder.marriage(reg_office.family_tree);
        }
    }

}
