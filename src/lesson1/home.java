package lesson1;
import java.util.Scanner;
import java.util.Calendar;
public class home {
    // В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида • "Доброе утро, <Имя>!", если время от 05:00 до 11:59 • 
    // "Добрый день, <Имя>!", если время от 12:00 до 17:59; • 
    // "Добрый вечер, <Имя>!", если время от 18:00 до 22:59; • "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите ваше имя: ");
        String name = iScanner.nextLine();
        Calendar now = Calendar.getInstance();
        String text = null;
        int time = now.get(Calendar.HOUR_OF_DAY);
        if (time >= 5 && time < 12) {
            text = "Доброе утро";
        } else if (time >= 12 && time < 18) {
            text = "Добрый день";
        } else if  (time >= 18 && time < 22) {
            text = "Добрый вечер";
        } else {
            text = "Доброй ночи";
        }
        System.out.println(text +  ", " + name + "!");
        iScanner.close();
    }
}
