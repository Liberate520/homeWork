package family_tree.view.console_commands;

import family_tree.model.human.Gender;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

import static family_tree.model.human.Gender.Female;
import static family_tree.model.human.Gender.Male;

public class ConsoleAddHuman{
    private String name;
    private Gender gender;
    private LocalDate localDate;
   private Scanner scanner;
   private TextConsole textConsole;
   private IsNumeric isNumeric;

    public ConsoleAddHuman() {
        this.scanner =  new Scanner(System.in);
        this.textConsole = new TextConsole();
        this.isNumeric = new IsNumeric();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public boolean addHuman() {
        System.out.println(textConsole.indicateNameText);

        name = scanner.nextLine();
        System.out.println(textConsole.indicateGenderText);

        String  gen = scanner.nextLine();
        if (!isNumeric.checkNum(gen)) {
            System.out.println(textConsole.genderIsIncorrectText);
            return false;
        }
        int iGen = Integer.parseInt(gen);
        if (iGen == 1) {
            gender = Male;
        } else if (iGen == 2) {
            gender = Female;
        } else {
            System.out.println(textConsole.genderIsIncorrectText);
            return false;
        }

        System.out.println(textConsole.enterYearOfBirthText);
        String year = scanner.nextLine();
        if (!isNumeric.checkNum(year)) {
            System.out.println(textConsole.enterYearOfBirthErrText);
            return false;
        }
        int iYear = Integer.parseInt(year);

        System.out.println(textConsole.enterMonthOfBirthText);
        String month = scanner.nextLine();
        if (!isNumeric.checkNum(month)) {
            System.out.println(textConsole.enterMonthOfBirthErrText);
            return false;
        }
        int iMonth = Integer.parseInt(month);
        if (iMonth < 1 || iMonth > 12) {
            System.out.println(textConsole.enterMonthOfBirthErrText);
            return false;
        }

        System.out.println(textConsole.enterBirthdayText);
        String dayOfMonth = scanner.nextLine();
        if (!isNumeric.checkNum(dayOfMonth)) {
            System.out.println(textConsole.enterBirthdayErrText);
            return false;
        }

        int iDayOfMonth = Integer.parseInt(dayOfMonth);
        YearMonth yearMonth = YearMonth.of(iYear, iMonth);
        int day = yearMonth.lengthOfMonth();
        if (iDayOfMonth < 0 || iDayOfMonth > day) {
            System.out.println(textConsole.enterBirthdayErrText);
            return false;
        }
        setLocalDate(LocalDate.of(iYear,iMonth,iDayOfMonth));
        return true;
    }
}
