package ui;

public class ChoiceChecker {
    int menuSize;

    ChoiceChecker(Menu menu) {
        menuSize = menu.getMenuCount();
    }

    public boolean isChoiceCorrect(String userChoice) {
        if (userChoice.matches("[0-9]")) {
            return Integer.parseInt(userChoice) <= menuSize && Integer.parseInt(userChoice) > 0;
        }
        return false;
    }
}
