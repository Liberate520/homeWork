package view;

import java.io.IOException;
import java.util.Scanner;

import presenter.Presenter;
import view.Starts.Start0;
import view.Starts.Start1;
import view.Starts.Start2;
import view.Starts.Start3;
import view.Starts.interfaceStart;
import model.FamilyTree.FamilyTree;
import model.FamilyTree.AddIntoTree.AddHuman;
import model.Persons.Human;
import model.Persons.Person;
import model.fileWork.FileHandlerRead;
import model.fileWork.FileHandlerSave;
import model.fileWork.Format.SaveDoc.InterfaceSave;
import model.fileWork.Format.SaveDoc.SaveBinFormat;
import model.fileWork.Format.SaveDoc.SaveDocFormat;
import model.fileWork.Format.SaveDoc.SaveMdFormat;
import model.fileWork.Format.SaveDoc.SaveTextFormat;

public class Console<T extends Person, E extends FamilyTree> implements View<T, E>
 {
    static Scanner scanner;
    private Presenter presenter;
    private static boolean work = true;

        public Console()
        {
            scanner = new Scanner(System.in, "Cp866");
        }

        public void exit()
        {
            System.out.println("Работа завершена, Вы вышли из программы! ");
            scanner.close();
            work = false;
        }


    @Override
    public void StartProgram() throws ClassNotFoundException, IOException 
    {
        while (work) 
            {
                interfaceStart interfaceStart = new Start0();
                int choice = interfaceStart.start();

            switch (choice) 
            {
                case 1:
                    ConsoleTreeFillsByHuman(); // наполнение дерева людьми и вывод дерева на экран
                    break;

                case 2:
                    SecondStartProgram();
                    break;
                    // FileHandlerSave fhs = new FileHandlerSave(); // запуск сохранения и чтения файлов!!!
                    // fhs.SaveFormat(person);
                case 3:
                    ConsoleFindPerson(); // поиск человека в дереве по имени и фамилии
                    break;
           
                case 4:
                    ConsoleSortById(); // сортировка дерева по id
                    break;

                case 5:
                    ConsoleSortLastName(); // сортировка дерева по имени
                    break;
                case 6:
                    exit(); // выход из программы
                    break;

                default:
                    System.out.println("Ошибка ввода, Вы ввели неправильные данные! ");
                    break;
            }
        }
    }

    public void SecondStartProgram() throws ClassNotFoundException, IOException
    {
        while(work)
        {
    interfaceStart interfaceStart = new Start1();
            int number = interfaceStart.start();
            
            switch (number)
                {

                case 1:
                    ConsoleSaveBinFormat(); // сериализация данных дерева в бинарный формат
                    System.out.println("Поздравляю!\n" + "Бинарный файл txt.bin был успешно создан!\n");
                    SecondStartProgram();
                    break;
                case 2:
                    ConsoleSaveTxtFormat();
                    System.out.println("Поздравляю!\n" + "Файл формата .txt был успешно создан!\n");
                    SecondStartProgram();
                    break;
                case 3:
                    ConsoleSaveDocFormat();
                    System.out.println("Поздравляю!\n" + "Файл формата .doc был успешно создан!\n");
                    SecondStartProgram();
                    break;
                case 4:
                    ConsoleSaveMdFormat();
                    System.out.println("Поздравляю!\n" + "Файл формата .md был успешно создан!\n");
                    SecondStartProgram();
                    break;
                case 5:
                    ThirdStartProgram();
                    break;
                case 6:
                    System.out.println("Вы вышли из программы.");
                    exit();
                    break;
          
                default: 
                System.out.println("Будьте внимательней при вводе! Некоректный ввод! ");
                break;
                }   
            }        
    }

    public void ThirdStartProgram() throws ClassNotFoundException, IOException
    {
        while(work)
        {
            interfaceStart interfaceStart = new Start2();
            int number = interfaceStart.start();
        
            switch (number)
            {
                case 1:
                    interfaceStart interfaceStart1 = new Start3();
                    int number2 = interfaceStart1.start();
            
                    switch (number2)
                    {
                        case 1:
                        ConsoleReadBinFormat();
                            System.out.println("Загрузка данных в программу из бинарного файла успешно завершена!\n");
                            StartProgram();
                            break;

                        case 2:
                            ConsoleReadTxtFormat();
                            System.out.println(" file.txt формата был успешно считан: \n");
                            StartProgram();
                            break;

                        case 3:
                            ConsoleReadDocFormat();
                            System.out.println(" file.doc формата был успешно считан: \n");
                            FileHandlerSave fhs3 = new FileHandlerSave();
                            StartProgram();
                            break;

                        case 4:
                            ConsoleReadMdFormat();
                            System.out.println(" file.md формата был успешно считан: \n");
                            FileHandlerSave fhs4 = new FileHandlerSave();
                            StartProgram();
                            break;

                        case 5:
                            System.out.println("Вы вышли из программы.");
                            exit();
                            break;
          
                        default: 
                        System.out.println("Будьте внимательней при вводе! Некоректный ввод! ");
                        break;
                    }  
                
                case 2:
                    SecondStartProgram();    
                    break;
                case 3: 
                    System.out.println("Вы вышли из программы!");
                    exit();
                    break;
                    

                default : 
                System.out.println("Будьте внимательней при вводе! Некоректный ввод! ");
                break;    
            } 
        }   
       
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
    
    /*методы консоли связанные с презентерем:  */

    public void ConsoleTreeFillsByHuman() // заполнения дерева людьми (Human)
    {
        presenter.PresenterTreeFillsByHuman();
    }

    public void ConsoleFindPerson() // поиск персоны в дереве по имени и фамилии
    {
        presenter.PresenterFindPerson();
    }

    public void ConsoleSortById() // сортировка дерева по id
    {
        presenter.PresenterSortById();
    }

    public void ConsoleSortLastName() // сортировка дерева по имени
    {
        presenter.PresenterSortByName();
    }

    // методы для записи дерева:

    public void ConsoleSaveBinFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterSaveBinFormat(); // сохранение в текстовом формате
    }

    public void ConsoleSaveTxtFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterSaveTxtFormat();
    }

    public void ConsoleSaveDocFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterSaveDocFormat();
    }

    public void ConsoleSaveMdFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterSaveMdFormat();
    }

    // методы для чтения дерева из файлов:

    public void ConsoleReadBinFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterReadBinFormat();
    }

    public void ConsoleReadTxtFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterReadTxtFormat();
    }

    public void ConsoleReadDocFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterReadDocFormat();
    }

    public void ConsoleReadMdFormat() throws IOException, ClassNotFoundException
    {
        presenter.PresenterReadMdFormat();
    }

}