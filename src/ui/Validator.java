package ui;


public class Validator {

    public int checkInput(String userInput, int size) {
        try {
            int choice = Integer.parseInt(userInput);
            if (choice >= 1 && choice <= size) {
                return choice;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
        return -1;
    }
}

