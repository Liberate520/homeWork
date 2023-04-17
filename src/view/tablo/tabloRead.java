package view.tablo;

public class tabloRead implements interfaceTablo
{

    @Override
    public void tablo() 
    {
        System.out.println("""
            Выберите формат чтения файла:

            1 - загрузить данные из файла в программу (загрузка  вывод данных из бинарного файла)

            2 - чтение данных из формата: file.txt

            3 - чтение данных из формата: формате: file.doc

            4 - чтение данных из формата: формате: file.md

            5 - Выйти из программы

            """);
    }
    
}
