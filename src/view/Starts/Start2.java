package view.Starts;

import view.tablo.interfaceTablo;
import view.tablo.tabloCross;

public class Start2 implements interfaceStart
{

    @Override
    public int start() 
    {
        interfaceTablo tablo = new tabloCross();
            tablo.tablo();
            int number = ReadNumber.readNumberConsole();
            while(number < 1 || number > 3)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo.tablo();
                number = ReadNumber.readNumberConsole();
            }
          return number;    
    }
    
}
