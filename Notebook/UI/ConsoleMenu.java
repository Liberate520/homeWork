package Notebook.UI;

import java.util.Scanner;

import Notebook.Core.MVP.Views.ViewMenu;


public class ConsoleMenu implements ViewMenu {

    Scanner iScanner;
    private final String textFotal = "Invalid input!";

    public ConsoleMenu() {
        iScanner = new Scanner(System.in);
    }

    @Override
    public int getNum() {
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = iScanner.next();
            if (isDigit(input)) {
                num = Integer.parseInt(input);
                if (num > 0) {
                    validInput = true;
                }
            }
            if (!validInput) {
                System.out.println(textFotal);
            }
        }        
        return num;
    }

    @Override
    public void setNum(int num) {
        System.out.printf("Selected menu item: %d\n", num);

    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getIndex() {
        int num = 0;
        boolean validInput = false;
        System.out.println("Enter the index: ");
        while (!validInput) {
            String input = iScanner.next();
            if (isDigit(input)) {
                num = Integer.parseInt(input);
                if (num > 0) {
                    validInput = true;
                }
            }
            if (!validInput) {
                System.out.println(textFotal);
            }
        }       
        return num;
    }

}
