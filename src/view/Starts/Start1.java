package view.Starts;

import view.tablo.interfaceTablo;
import view.tablo.tabloSave;

public class Start1 implements interfaceStart
{

    @Override
    public int start() 
    {
            interfaceTablo tablo = new tabloSave();
            tablo.tablo();
            int number = ReadNumber.readNumberConsole();
            while(number < 1 || number > 6)
              {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                // 
                tablo.tablo();
                number = ReadNumber.readNumberConsole();
              }  
        return number;
        }
 
    }
    

