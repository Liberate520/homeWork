package view.Starts;

import java.util.Scanner;

public class ReadNumber 
{
    public static int readNumberConsole()
    {
        System.out.println(" Введите номер операции: ");
        Scanner sc = new Scanner(System. in, "Cp866");
            if(sc.hasNextInt())
                {
                    int number  = sc.nextInt();
                    return number; 
                }  
                else
                {
                    System.out.println("Вы ввели не число! Введите число! ");
                    return readNumberConsole();
                            
                }                  
    }

}
