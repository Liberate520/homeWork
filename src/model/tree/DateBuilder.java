package homeWork.src.model.tree;

import java.time.LocalDate;
import java.util.Scanner;

public class DateBuilder {

    private String day;
    private String month;
    private String year;
    private LocalDate date;
    private Scanner scanner = new Scanner(System.in);

    public LocalDate buildDate(){

        System.out.println("Enter day: ");
        day = scanner.nextLine();
        // Check the correctness of entered data

        System.out.println("Enter month: ");
        month = scanner.nextLine();
        // Check the correctness of entered data

        System.out.println("Enter year: ");
        year = scanner.nextLine();
        // Check the correctness of entered data

        return date = LocalDate.parse(year + "-" + month + "-" + day);
    }

}
