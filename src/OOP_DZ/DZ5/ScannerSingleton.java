package OOP_DZ.DZ5;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner scanner;

    public static Scanner getScanner() {
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
