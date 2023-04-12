package view;

import java.io.IOException;
import java.util.Scanner;
import model.FamilyTree;
import presenter.Presenter;
import view.Starts.Start0;
import view.Starts.interfaceStart;
import model.fileWork.FileHandlerSave;

public class Console<T> implements View<T>
 {
    static Scanner scanner;
    private Presenter presenter;
    private static boolean work = true;

        public Console()
        {
            scanner = new Scanner(System.in, "Cp866");
        }

        public static void exit()
        {
            System.out.println("Работа завершена, Вы вышли из программы! ");
            scanner.close();
            work = false;
        }


    @Override
    public T StartProgram(T t) throws ClassNotFoundException, IOException 
    {
        while (work) 
            {
                interfaceStart interfaceStart = new Start0();
                int choice = interfaceStart.start();

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
    public void print(T t) 
    {
        System.out.println("По Вашему запросу выводим на экран фамильное дерево:\n" + t);
    }

    @Override
    public void setPresenter(Presenter presenter) 
    {
        this.presenter = presenter;
    }   
}