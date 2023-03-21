package Notebook.UI;

import java.util.Scanner;

import Notebook.Core.MVP.Views.ViewMenu;

public class ConsoleMenu implements ViewMenu {
    Scanner iScanner;

    public ConsoleMenu() {
        iScanner = new Scanner(System.in);
    }

    @Override
    public int getNum()  {
        String num = iScanner.next();
        if (isDigit(num)) {
            if (Integer.parseInt(num) > 0)
                return Integer.parseInt(num);
        }
        
        return 10;
    }

    @Override
    public void setNum(int num) {
        System.out.printf("Selected menu item: %d\n", num);

    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
