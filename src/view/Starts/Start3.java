package view.Starts;

import view.tablo.interfaceTablo;
import view.tablo.tabloRead;

public class Start3 implements interfaceStart
{

    @Override
    public int start() 
    {
        interfaceTablo tablo = new tabloRead();
            tablo.tablo();
            int number = ReadNumber.readNumberConsole();
            while(number < 1 || number > 5)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo.tablo();
                number = ReadNumber.readNumberConsole();
            }
          return number;
    }
    
}
