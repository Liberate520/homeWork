package Seminar6.src.ui;

import java.util.Scanner;

public class CheckingInput {

    public static boolean signal = true;
    public static Scanner scanner = new Scanner(System.in);

    /*
    проверяем на " out of range "
     */

    public static int checkNumberOutOfRange(int size){
        int num = 0;
        while (signal){
            num = scanner.nextInt();
            signal = num > size || num <= 0;
            if(signal) System.out.println("введите корректную цифру");
        }
        signal = true;
        return num;
    }
    /*
    проверка на  невозможность удаления и изменения в пустом списке
     */
    public static int checkNumberSizeZero(int num,int size){
        while ( signal){
            signal = size == 0 && (num == 2 || num == 4);
            if(signal) {
                System.out.println("записная пуста," +
                        " нажмите 1 чтобы добавить запись");
                num = scanner.nextInt();
            }

        }
        signal = true;
        return num;
    }
}
