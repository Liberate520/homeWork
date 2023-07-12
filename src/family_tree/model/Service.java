package family_tree.model;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.registry_office.Reg_office;


import java.time.LocalDate;

public class Service {

    public Reg_office reg_office;
    public Date_using date_using;

    public Service() {
        reg_office = new Reg_office();
        date_using = new Date_using();
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


}
