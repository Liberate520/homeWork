package family_tree.model.registry_office;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.infrastucture.Config;
import family_tree.model.infrastucture.de_serelization.File_using;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.model.tree.FamilyTree;

import java.time.LocalDate;


public class Reg_office {



    private FamilyTree<Human> family_tree;
    private final File_using file_using;
    private final Date_using date_using;
    private final Relatives_finder relatives_finder;


    public Reg_office() {
        family_tree = new FamilyTree<>();
        file_using = new File_using();
        date_using = new Date_using();
        relatives_finder = new Relatives_finder();


    }

    public String add_human(String surname, String first_name, String patronymic, String str_gender, String str_day_birth){
        Gender gender = tryGender(str_gender);
        LocalDate day_birth = date_using.tryLocalDate(str_day_birth);
        Human human = new Human(surname, first_name, patronymic, gender, day_birth);
        if (human != null) {
            family_tree.addToHumanList(human);
            return "Добавлен новый член:\n" + human;
        } else {
            return "Что-то пошло не так";
        }
    }


    public Gender tryGender(String string) {
        Gender gender = Gender.Mail;
        if (!string.isEmpty()) {
            gender = Gender.Female;
        }
        return gender;
    }
    public void setFamily_tree(FamilyTree<Human> family_tree) {
        this.family_tree = family_tree;
    }

    public FamilyTree<Human> getFamily_tree() {
        return family_tree;
    }

    public String treeInfo_sortByID() {
        family_tree.sortById();
        return family_tree.toString();
    }

    public String treeInfo_sortByAge() {
        family_tree.sortByAge();
        return family_tree.toString();
    }

    public String treeInfo_sortByName() {
        family_tree.sortByName();
        return family_tree.toString();
    }

    public Boolean saveFamily_tree(){
        return file_using.save(family_tree, Config.filePath);
    }
    public void loadFamily_tree() {
        setFamily_tree((FamilyTree<Human>) file_using.load(Config.filePath));
    }

    public void parents_finder() {
        setFamily_tree(relatives_finder.parents_finder(family_tree));
    }

    public void adoption() {
        setFamily_tree(relatives_finder.adoption(family_tree));
    }

    public void marriage() {
        setFamily_tree(relatives_finder.marriage(family_tree));
    }

}
