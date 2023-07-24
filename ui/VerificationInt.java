package ui;

import java.util.Scanner;

public class VerificationInt {
    private Scanner scanner;

        public VerificationInt(){
        this.scanner = new Scanner(System.in);
    }

    private int translationStringIntoInteger(String parseInt) {
        if (isNumeric(parseInt)) {
            int integerParse = Integer.parseInt(parseInt);
            return integerParse;
        } else {
            while (!isNumeric(parseInt)) {
                System.out.println("Введите число: ");
                parseInt = scanner.nextLine();
            }
            int integerParse = Integer.parseInt(parseInt);
            return integerParse;
        }
    }

    public int verificationInt(String parseInt, int sizeLimit) {
        int isInt = translationStringIntoInteger(parseInt);
        while (!(isInt < sizeLimit + 1 && isInt > 0)) {
            System.out.println("Введите число от 1 до " + sizeLimit + ": " );
            parseInt = scanner.nextLine();
            isInt = translationStringIntoInteger(parseInt);
        }
        return isInt;
    }


    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
