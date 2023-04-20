package view.starts;
import java.util.Scanner;

public class ReadNumber
{
    public static int readNumberConsole()
    {
        System.out.printf("Ожидание выбора: ");
        Scanner sc = new Scanner(System. in, "Cp866");
        if(sc.hasNextInt())
        {
            int number  = sc.nextInt();
            return number;
        }
        else
        {
            System.out.println("Вы ошиблись! ");
            return readNumberConsole();

        }
    }

}

