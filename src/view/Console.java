package view;
import java.io.IOException;
import java.util.Scanner;
import model.Service;
import model.FamilyTree;
import presenter.Presenter;
import model.FileHandlerSave;
import model.FileHandlerRead;

public class Console<T> implements View<T>
 {
    static Scanner scanner;
    private Presenter presenter;
    public static boolean work = true;

    public Console()
    {
        scanner = new Scanner(System.in, "Cp866");
    }

    private static int readNumberConsole()
    {
        System.out.println(" Введите номер операции: ");
        Scanner sc = new Scanner(System. in, "Cp866");
        // System.out.println(" Введите номер операции: ");
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
 
    public static void exit()
    {
        System.out.println("Работа завершена, Вы вышли из программы! ");
        scanner.close();
        work = false;
    }

    
        public static void tabloFirst()
        {
            System.out.println("""
                                Выберите формат сохранения фамильного дерева:
    
                                1 - Вывести на экран фамильное дерево:
    
                                2 - работа с файломи

                                3 - найти человека

                                4 - отсортировать дерево по id

                                5 - отсортировать дерево по имени и фамилии
    
                                6 - Выход из программы
                                """);
        }
    
        public static void tabloSave()
        {
            System.out.println("""
                                Выберите формат сохранения фамильного дерева:
    
                                1 - зделать сериализацию данных (записать файл с бинарными данными)
    
                                2 - сохранение в формате: file.txt
    
                                3 - сохранение данных в формате: file.doc
    
                                4 - сохранение данных в формате: file.md
    
                                5 - перейти на чтение сохраненных файлов
    
                                6 - Выход из программы
    
                                """);
        }

        public static void tabloRead2()
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

    public static void tabloRead11()
    {
        System.out.println("""
                            Хотите прочесть содержание записанного Вами файла?

                            1 - Да, хочу прочесть

                            2 - Нет, нехочу этого делать сейчас, хочу продолжить работу с сохранением данных в файл

                            3 - Выход

                            """);
    }    

    public static <T> int Start1(T t)
        {
            Console.tabloSave();
            int number = readNumberConsole();
            while(number < 1 || number > 6)
              {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                Console.tabloSave();
                number = readNumberConsole();
              }  
        return number;
        }

        public static <T> int Start2(T t)
        {
            Console.tabloRead11();
            int number = readNumberConsole();
            while(number < 1 || number > 3)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                Console.tabloRead11();
                number = readNumberConsole();
            }
          return number;
        }
        
        public static <T> int Start3(T t)
        {
            Console.tabloRead2();
            int number = readNumberConsole();
            while(number < 1 || number > 5)
            {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                Console.tabloRead2();
                number = readNumberConsole();
            }
          return number;
        }

    
    @Override
    public T StartProgram(T t) throws ClassNotFoundException, IOException 
    {
        while (work) 
            {
            tabloFirst();

            int choice = readNumberConsole();

                while(choice < 1 || choice > 6)
              {
                System.out.println("Вы ввели не верный номер операции!\n Введите его снова!");
                tabloFirst();
                choice = readNumberConsole();
              }  

            switch (choice) 
            {
                case 1:
                    presenter.Show(t);
                    break;
                case 2:
                    FileHandlerSave fhs = new FileHandlerSave(); // запуск сохранения и чтения файлов!!!
                    fhs.SaveFormat(t);
                    break;
                case 3:
                    presenter.startFindHuman((FamilyTree) t);
                    break;
                case 4:
                    presenter.SortId(t);
                    break;
                case 5:
                    presenter.sortLastName(t);
                    break;
                case 6:
                    exit();
                    break;

                default: break;
            }
        }
       return null;
    }

    @Override
    public void print(T t) {
        System.out.println("По Вашему запросу выводим на экран фамильное дерево:\n" + t);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    
    
}