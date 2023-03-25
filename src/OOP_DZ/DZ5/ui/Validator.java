package OOP_DZ.DZ5.ui;

import OOP_DZ.DZ5.ScannerSingleton;

import java.util.Scanner;

public class Validator {
    Scanner scanner;

    public Validator() {
        this.scanner = ScannerSingleton.getScanner();
    }

    public Integer valMenuChoice(String numberFromScanner, int till) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Integer.parseInt(numberFromScanner) > 0 && Integer.parseInt(numberFromScanner) <= till) {//
                    return Integer.parseInt(numberFromScanner);
                } else {
                    System.out.printf("Enter number from 1 till %s: ", till);
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.printf("Enter number from 1 till %s: ", till);
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public Integer valInt(String numberFromScanner) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Integer.parseInt(numberFromScanner) > -2_147_483_648 && Integer.parseInt(numberFromScanner) < 2_147_483_647) {//
                    return Integer.parseInt(numberFromScanner);
                } else {
                    System.out.print("Enter number: ");
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.print("Enter number: ");
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public double valDouble(String numberFromScanner) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Double.parseDouble(numberFromScanner) > -2_147_483_648.0 && Double.parseDouble(numberFromScanner) < 2_147_483_647.0) {//
                    return Double.parseDouble(numberFromScanner);
                } else {
                    System.out.print("Enter real number: ");
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.print("Enter real number: ");
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public String emergency_exit(String string) {
        if (string.equals("exit")) {
            System.out.println("\nEmergency exit without saving data\n");
            System.exit(0);
        }
        return string;
    }
}
