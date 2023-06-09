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
        
        print("Enter new fullname ( old: \"" + presenter.getMemberName(input) + "\") or enter empty: \n");
        String fullname = getStringInput(null);
        if(!fullname.equals("")){
            presenter.setName(input, fullname);
            print("You entered: " + fullname + "\n");
        }

        print("Enter new birthday ( old: \"" + presenter.getMemberDate(input) + "\") or enter empty: \n");
        LocalDate date = getDateInput(true);
        if(date == null){
            presenter.setDate(input, date);
            print("You entered: " + fullname + "\n");
        }

        print("Enter new gender ( old: \"" + presenter.getMemberDate(input) + "\") or enter empty: \n");
        print(presenter.getGendersList());
        int gender = getIntegerInput(0, 2) - 1;
        if(gender != -1){
            presenter.setGender(input, gender);
            print("You entered: " + presenter.getGender(gender) + "\n");
        }
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
    // #endregion
}

/*
 * OUTPUT ===================================

1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 1
        |> 1. John Johnson (1910-01-02)[Male]
        |> 2. Eliza Johnson (1909-02-04)[Female]
        |> 3. Donald Ferguson (1908-03-06)[Male]
        |> 4. Mike Johnson (1930-04-10)[Male]
        |> 5. Betty Ferguson (1925-05-12)[Female]
        |> 6. Bobby Johnson (1950-06-14)[Male]
        |> 7. Christine Johnson (1955-07-16)[Female]
        |> 8. Steve Gomez (1951-08-18)[Male]
1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 2
Enter fullname:
> Bobby Gomez
You entered: Bobby Gomez
Enter birthday ("dd.MM.YYYY"):
> 25.05.1971
You entered: 25.05.1971
Enter gender ('m' or 'f'):
        |> 1. Male
        |> 2. Female
> 1
You entered: Male
Select father(0 for keep empty):
        |> 1. John Johnson (1910-01-02)[Male]
        |> 2. Donald Ferguson (1908-03-06)[Male]
        |> 3. Mike Johnson (1930-04-10)[Male]
        |> 4. Bobby Johnson (1950-06-14)[Male]
        |> 5. Steve Gomez (1951-08-18)[Male]
> 5
You entered: Steve Gomez
Select mother(0 for keep empty):
        |> 1. Eliza Johnson (1909-02-04)[Female]
        |> 2. Betty Ferguson (1925-05-12)[Female]
        |> 3. Christine Johnson (1955-07-16)[Female]
> 0
You entered: 'unknown'
New member Bobby Gomez was added successful
1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 3
Enter a number of member for print detail       
        |> 1. John Johnson (1910-01-02)[Male]
        |> 2. Eliza Johnson (1909-02-04)[Female]
        |> 3. Donald Ferguson (1908-03-06)[Male]
        |> 4. Mike Johnson (1930-04-10)[Male]
        |> 5. Betty Ferguson (1925-05-12)[Female]
        |> 6. Bobby Johnson (1950-06-14)[Male]
        |> 7. Christine Johnson (1955-07-16)[Female]
        |> 8. Steve Gomez (1951-08-18)[Male]
        |> 9. Bobby Gomez (1971-05-25)[Male]
> 9
Detail:
Bobby Gomez (25 May 1971)
[Male] 0 children,
father: Steve Gomez
1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 4
Enter a number of member for edit
        |> 1. John Johnson (1910-01-02)[Male]
        |> 2. Eliza Johnson (1909-02-04)[Female]
        |> 3. Donald Ferguson (1908-03-06)[Male]
        |> 4. Mike Johnson (1930-04-10)[Male]
        |> 5. Betty Ferguson (1925-05-12)[Female]
        |> 6. Bobby Johnson (1950-06-14)[Male]
        |> 7. Christine Johnson (1955-07-16)[Female]
        |> 8. Steve Gomez (1951-08-18)[Male]
        |> 9. Bobby Gomez (1971-05-25)[Male]
> 9
Enter new fullname ( old: "Bobby Gomez") or enter empty:
>
Enter new birthday ( old: "1971-05-25") or enter empty:
> 26.06.1972
Enter new gender ( old: "1971-05-25") or enter empty:
        |> 1. Male
        |> 2. Female
> 1
You entered: Male
1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 3
Enter a number of member for print detail       
        |> 1. John Johnson (1910-01-02)[Male]
        |> 2. Eliza Johnson (1909-02-04)[Female]
        |> 3. Donald Ferguson (1908-03-06)[Male]
        |> 4. Mike Johnson (1930-04-10)[Male]
        |> 5. Betty Ferguson (1925-05-12)[Female]
        |> 6. Bobby Johnson (1950-06-14)[Male]
        |> 7. Christine Johnson (1955-07-16)[Female]
        |> 8. Steve Gomez (1951-08-18)[Male]
        |> 9. Bobby Gomez (1971-05-25)[Male]
> 9
Detail:
Bobby Gomez (25 May 1971)
[Male] 0 children,
father: Steve Gomez
1. Print info
2. Add new member
3. Print detail
4. Edit
5. Quit
> 5
 */
