import java.util.Scanner;

public class ScanNumber
{

    static int ScanOperationNumber()
    {
        Scanner sc = new Scanner(System. in, "Cp866");
        System.out.println("\nВведите номер операции: ");
        if(sc.hasNextInt())
            {
                String s = sc.nextLine();
                int number = Integer.parseInt(s);
                return number; 
            }  
        else
            {
                System.out.println("Вы ввели не число! Введите число! ");
                return ScanOperationNumber();
            } 

            
    }
    
}
