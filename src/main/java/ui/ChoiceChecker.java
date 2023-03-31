package ui;

import ui.menu.Menu;

public class ChoiceChecker {
    int menuSize;

    ChoiceChecker(Menu menu) {
        menuSize = menu.getMenuCount();
    }
    public boolean isNumber(String userChoice) {
        if (userChoice.matches("[0-9]")) {
            return true;
        }
        return false;
    }
    public boolean isChoiceCorrect(String userChoice) {
        if (userChoice.matches("[0-9]")) {
            return Integer.parseInt(userChoice) <= menuSize && Integer.parseInt(userChoice) > 0;
        }
        return false;
    }
}
