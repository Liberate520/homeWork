package family_tree.view.consoleUI.menu.menuWorkWithTree;

import family_tree.model.gender.Gender;
import family_tree.view.consoleUI.ConsoleUi;
import family_tree.view.consoleUI.menu.Command;

import java.time.LocalDate;
import java.util.Scanner;

public class AddItem extends Command {

    private String name;
    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private Gender gender;
    public AddItem(ConsoleUi consoleUi) {
        super("Add item.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().printAnswer("Name:");
        name = getConsoleUi().getScanner().nextLine();
        getConsoleUi().printAnswer("Birthday: year-month-day");
        String birthdayDate = getConsoleUi().getScanner().nextLine();
        birthday = LocalDate.parse(birthdayDate);
        getConsoleUi().printAnswer("Day of death: year-month-day");
        String dayOfDeathDate = getConsoleUi().getScanner().nextLine();
        dayOfDeath = LocalDate.parse(dayOfDeathDate);
        getConsoleUi().printAnswer("Gender: m/f");
        String genderInput = getConsoleUi().getScanner().nextLine();
        if (genderInput.equals("m")) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        getConsoleUi().addItem(name, birthday, dayOfDeath, gender);
    }

}
