package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import presenter.Presenter;

public class ConsoleUI implements View {

    // #region fields
    private Presenter presenter;
    private Scanner scanner;
    private boolean isWork;
    private MainMenu mainMenu;
    private DateTimeFormatter formatter;
    // #endregion

    public ConsoleUI() {
        isWork = true;
        presenter = new Presenter();
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    // #region implements
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        do {
            print(mainMenu.getMenu());
            int input = getIntegerInput(1, mainMenu.getSize());
            mainMenu.execute(input);
        } while (isWork);
    }
    // #endregion

    // #endregion commands
    public void printDetail() {
        print("Enter a number of member for print detail\n");
        print(presenter.getAllMembers());
        int input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        print("Detail: \n");
        print(presenter.getMemberDetail(input));
    }

    public void printAll() {
        print(presenter.getAllMembers());
    }

    public void quit() {
        isWork = false;
    }

    public void addNewMember() {
        String fullname = getName();

        if (presenter.addNewMember(fullname, getDate(), getGender(), getFatherIndex(), getMotherIndex())) {
            print("New member " + fullname + "was added successful\n");
        } else {
            print("something went wrong");
        }
    }
    
    public void editMember(){
        print("Enter a number of member for edit \n");
        print(presenter.getAllMembers());
        int input = getIntegerInput(1, presenter.getAllMembersAmount()) - 1;
        
        changeName(input);

        changeBirthday(input);

        changeGender(input);

        changeFather(input);

        changeMother(input);

        print("Changed apply successful \n");
    }    
    
    public void save(){
        presenter.save();
    }
    // #endregion

    // #region inputs
    private LocalDate getDateInput(boolean canBeNull) {
        String input = "";
        do {
            print("> ");
            input = scanner.nextLine();

            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                if(input.equals("") && canBeNull) return null;
            }
        } while (true);
    }

    private int getIntegerInput(int min, int max) {
        String input = "";
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                int parsed = Integer.parseInt(input);
                if (parsed >= min && parsed <= max)
                    return parsed;
            }
        } while (true);
    }

    private String getStringInput(String[] match) {
        String input = "";
        do {
            print("> ");
            input = scanner.nextLine();
            if (match == null) {
                return input;
            } else if (contains(match, input)) {
                return input;
            }
        } while (true);
    }
    // #endregion

    // #region helpers
    private boolean contains(String[] match, String input) {
        for (int i = 0; i < match.length; i++) {
            if (input.equals(match[i])) {
                return true;
            }
        }
        return false;
    }

    private int getMotherIndex() {
        print("Select mother(0 for keep empty): \n");
        print(presenter.getFemalesNames());
        int mother = getIntegerInput(0, presenter.getFemaleAmount()) - 1;
        if (mother == -1) {
            print("You entered: 'unknown'\n");
        } else {
            print("You entered: " + presenter.getFemale(mother) + "/n");
        }
        return mother;
    }

    private int getFatherIndex() {
        print("Select father(0 for keep empty): \n");
        print(presenter.getMalesNames());
        int father = getIntegerInput(0, presenter.getMaleAmount()) - 1;
        if (father == -1) {
            print("You entered: 'unknown'\n");
        } else {
            print("You entered: " + presenter.getMale(father) + "\n");
        }
        return father;
    }

    private int getGender() {
        print("Enter gender ('m' or 'f'):\n");
        print(presenter.getGendersList());
        int gender = getIntegerInput(1, 2) - 1;
        print("You entered: " + presenter.getGender(gender) + "\n");
        return gender;
    }

    private LocalDate getDate() {
        print("Enter birthday (\"dd.MM.YYYY\"):\n");
        LocalDate date = getDateInput(false);
        print("You entered: " + formatter.format(date) + "\n");
        return date;
    }

    private String getName() {
        print("Enter fullname:\n");
        String fullname = getStringInput(null);
        print("You entered: " + fullname + "\n");
        return fullname;
    }
   
    private void changeMother(int input) {
        print("Enter new mother (0 for keep old, -1 for remove): \n");
        print(presenter.getMalesNames());
        int mother = getIntegerInput(0, presenter.getMaleAmount()) - 1;
        if (mother != -1) {
            presenter.setMother(input, mother);
        }
    }

    private void changeFather(int input) {
        print("Enter new father (0 for keep old, -1 for remove): \n");
        print(presenter.getMalesNames());
        int father = getIntegerInput(0, presenter.getMaleAmount()) - 1;
        if (father != -1) {
            presenter.setFather(input, father);
        }
    }

    private void changeGender(int input) {
        print("Enter new gender ( old: \"" + presenter.getMemberDate(input) + "\") or enter empty: \n");
        print(presenter.getGendersList());
        int gender = getIntegerInput(0, 2) - 1;
        if(gender != -1){
            presenter.setGender(input, gender);
            print("You entered: " + presenter.getGender(gender) + "\n");
        }
    }

    private void changeBirthday(int input) {
        print("Enter new birthday ( old: \"" + presenter.getMemberDate(input) + "\") or enter empty: \n");
        LocalDate date = getDateInput(true);
        if(date == null){
            presenter.setDate(input, date);
        }
    }

    private void changeName(int input) {
        print("Enter new fullname ( old: \"" + presenter.getMemberName(input) + "\") or enter empty: \n");
        String fullname = getStringInput(null);
        if(!fullname.equals("")){
            presenter.setName(input, fullname);
            print("You entered: " + fullname + "\n");
        }
    }

    // #endregion
}