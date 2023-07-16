package family_tree.model.registry_office;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.model.tree.FamilyTree;

import java.time.LocalDate;


public class Reg_office {



    private FamilyTree<Human> family_tree;
    private Date_using date_using;


    public Reg_office() {
        family_tree = new FamilyTree<>();
        date_using = new Date_using();
    }


    public Human add_human(String surname, String first_name, String patronymic, String str_gender, String str_day_birth){
        Gender gender = tryGender(str_gender);
        LocalDate day_birth = date_using.tryLocalDate(str_day_birth);
        Human human = new Human(surname, first_name, patronymic, gender, day_birth);
        family_tree.addToHumanList(human);
        return human;
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


}
