package family_tree.registry_office;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.model.infrastucture.de_serelization.My_Serialization;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;


public class Reg_office implements My_Serialization, My_Scanner {



    public FamilyTree family_tree;

    public Reg_office() {
        family_tree = new FamilyTree();
    }


    public Human add_human(String surname, String first_name, String patronymic, Gender gender, LocalDate day_birth){
        Human human = new Human(surname, first_name, patronymic, gender, day_birth);
        System.out.println(family_tree);
        this.family_tree.addToHumanList(human);
        return human;
    }
    public Gender tryGender(String string) {
        Gender gender = Gender.Mail;
        if (!string.isEmpty()) {
            gender = Gender.Female;
        }
        return gender;
    }
    public void setFamily_tree(FamilyTree family_tree) {
        this.family_tree = family_tree;
    }

    public FamilyTree getFamily_tree() {
        return family_tree;
    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        return false;
    }

    @Override
    public Object load(String filePath) {
        return null;
    }
}
