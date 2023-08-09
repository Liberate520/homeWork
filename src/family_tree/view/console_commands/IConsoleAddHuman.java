package family_tree.view.console_commands;

import family_tree.model.human.Gender;

import java.time.LocalDate;

public interface IConsoleAddHuman {
    boolean addHumanCon();
    String getName();
    Gender getGender();
    LocalDate getLocalDate();
}
