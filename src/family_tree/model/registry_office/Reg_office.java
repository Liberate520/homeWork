package family_tree.model.registry_office;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.infrastucture.My_Scanner;
import family_tree.model.infrastucture.de_serelization.My_Serialization;
import family_tree.model.infrastucture.try_catch.Date_using;
import family_tree.model.tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;


public class Reg_office implements My_Serialization, My_Scanner {

    Scanner sc = My_Scanner.sc;

    public FamilyTree getFamily_tree() {
        return family_tree;
    }

    public FamilyTree family_tree = new FamilyTree();
    Date_using du = new Date_using();
    private Human new_human(){
        System.out.println("\nВвод данных нового человека.");
        System.out.print("Фамилия: ");
        String surname = sc.nextLine().trim();
        System.out.print("Имя: ");
        String first_name = sc.nextLine().trim();
        System.out.print("Отчество: ");
        String patronymic = sc.nextLine().trim();
        System.out.print("Дата рождения (dd.mm.yyyy): ");
        LocalDate day_birth = du.tryLocalDate(sc.nextLine().trim());
        System.out.print("Пол (по умолчанию M, для смены пола введите любой символ: ");
        Gender gender  = tryGender(sc.nextLine().trim());
        Human human = new Human(surname, first_name, patronymic, gender, day_birth);
        return human;
    }
    public void add_human(){
        Human human = new_human();
        family_tree.addToHumanList(human);
        System.out.println("Добавлен новый член.");
        System.out.println(human);
    }
    private Gender tryGender(String string) {
        Gender gender = Gender.Mail;
        if (!string.isEmpty()) {
            gender = Gender.Female;
        }
        return gender;
    }
    public void setFamily_tree(FamilyTree family_tree) {
        this.family_tree = family_tree;
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
