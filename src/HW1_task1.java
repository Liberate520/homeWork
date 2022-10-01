import java.time.LocalTime;
import java.util.Scanner;

public class HW1_task1 {
    public static LocalTime time = LocalTime.now();

    static boolean timeInRange(LocalTime leftLimit, LocalTime rightLimit){
        return time.isAfter(leftLimit) && time.isBefore(rightLimit);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = in.nextLine();



        if (timeInRange(LocalTime.of(5, 0), LocalTime.of(11,59))){
            System.out.println("G morning, "+ name + '!');
        }
        else if (timeInRange(LocalTime.of(12, 0), LocalTime.of(17,59))) {
            System.out.println("G day, "+ name + '!');
        }
        else if (timeInRange(LocalTime.of(18, 0), LocalTime.of(22,59))) {
            System.out.println("G evening, "+ name + '!');
        }
        else if (timeInRange(LocalTime.of(23, 0), LocalTime.of(4,59))) {
            System.out.println("G night, "+ name + '!');
        }
        in.close();

    }


}
