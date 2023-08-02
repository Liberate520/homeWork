package view.commands;

import model.Organisms.Person.OrganismType;
import model.Organisms.Person.Sex;
import presenter.Presenter;
import view.Text;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonAdder implements Command{
    String description = "Add person";

    public void start(Presenter presenter){
        Scanner scanner = new Scanner(System.in);
        Text.inputOrganismType();
        String organismTypeString = scanner.next();
        OrganismType organismType = OrganismType.valueOf(organismTypeString);
        Text.inputName();
        String name = scanner.next();
        Text.inputBirthday();
        LocalDate date = LocalDate.parse(scanner.next());
        Text.inputSex();
        Sex sex = Sex.valueOf(scanner.next());
        presenter.addPerson(organismType, name, date, sex);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
