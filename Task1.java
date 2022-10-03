import java.util.Scanner;
import java.util.Date;

public class Task1 {

    /**
     * @param args
     */
    public static void main(String [] args){

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Каково ваше имя? ");
        String name = iScanner.nextLine();
        System.out.println(name);
        Date date1 = new Date();
        int time = date1.getHours();
        if (time >= 5 & time  < 12) {
            String hi = "Доброе утро "+  name;
            System.out.println(hi);
                       
        }
        else if (time >= 12 & time  < 18) {
            String hi = "Добрый день  "+  name;
            System.out.println(hi);
        }
        else if (time >= 18 & time  < 23) {
            String hi = "Добрый вечер "+  name;
            System.out.println(hi);
        }
        else if (time >= 23 & time  < 24) {
            String hi = "Доброй ночи "+  name;
            System.out.println(hi);
        }
        else if (time >= 0 & time  < 5) {
            String hi = "Доброй ночи "+  name;
            System.out.println(hi);
        }
        
        
        iScanner.close();

}
}
