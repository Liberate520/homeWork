package view.Starts;

import view.tablo.interfaceTablo;
import view.tablo.tabloStart;

public class Start0 implements interfaceStart
{

    @Override
    public int start() 
    {
        interfaceTablo tablo = new tabloStart();
            tablo.tablo();
            int choice = ReadNumber.readNumberConsole();

                while(choice < 1 || choice > 6)
              {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tablo.tablo();
                choice = ReadNumber.readNumberConsole();
              }  
        return choice;     
    }
    
}
