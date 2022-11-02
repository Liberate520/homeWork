
// В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида 
// • "Доброе утро, <Имя>!", если время от 05:00 до 11:59 
// • "Добрый день, <Имя>!", если время от 12:00 до 17:59; 
// • "Добрый вечер, <Имя>!", если время от 18:00 до 22:59; 
// • "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
import java.util.Scanner;
import java.time.LocalTime;

public class task_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        iScanner.close();

        LocalTime current_time = LocalTime.now();

        if (current_time.getHour() < 12 && current_time.getHour() >= 5) {
            System.out.printf("Доброе утро, %s!", name);
        } else if (current_time.getHour() >= 12 && current_time.getHour() < 18) {
            System.out.printf("Добрый день, %s!", name);
        } else if (current_time.getHour() >= 18 && current_time.getHour() < 23) {
            System.out.printf("Добрый вечер, %s!", name);
        } else {
            System.out.printf("Доброй ночи, %s!", name);

        }
    }
}
