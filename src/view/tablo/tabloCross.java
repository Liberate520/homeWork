package view.tablo;

public class tabloCross implements interfaceTablo
{

    @Override
    public void tablo() {
        System.out.println("""
            Хотите прочесть содержание записанного Вами файла?

            1 - Да, хочу прочесть

            2 - Нет, нехочу этого делать сейчас, хочу продолжить работу с сохранением данных в файл

            3 - Выход

            """);
    }
   
}
