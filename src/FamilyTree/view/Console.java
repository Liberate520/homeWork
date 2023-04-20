package FamilyTree.view;

import java.io.IOException;
import java.util.Scanner;

import FamilyTree.model.fileManagement.SaveLoad;
import FamilyTree.presenter.Presenter;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private SaveLoad sl;
    private boolean work = true;
    private String pathToSave;

    public Console() {
        scanner = new Scanner(System.in, "cp866");
        System.out.println("Консоль готова к работе");
    }


    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        
        while (work) {
            System.out.println("1 - добавить новую запись\n" +
                    "2 - вывести все на экран\n" +
                    "3 - завершить работу");
                    System.out.print("Введите команду: ");
                    String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addRecord();
                    break;
                case "2":
                    viewAll();
                    break;
                case "3":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }

    @Override
    public void askAndAnswer(String question) {
        System.out.print(question);
        String msg = scanner.nextLine();
        presenter.getAnswer(msg);
    }

    private void addRecord(){
        presenter.addRecord();
    }
    private void viewAll(){
        presenter.getRecords();
    }

    private void exit() {
        try {
            save(sl, pathToSave);
        } catch (ClassNotFoundException e) {
            print("Ошибка сериализации: " + e.getMessage());
        } catch (IOException e) {
            print("Ошибка ввода/вывода: " + e.getMessage());
        }
        print("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    private void save(SaveLoad sl, String path) throws ClassNotFoundException, IOException {//
        presenter.save(sl,path);
    }
    
    @Override
    public void saveInit(SaveLoad sl, String path) {
        this.sl = sl;
        pathToSave = path;
    }

    @Override
    public void load(SaveLoad sl, String path) {
        try {
            presenter.load(sl,path);
        } catch (ClassNotFoundException e) {
            print("Ошибка десериализации: " + e.getMessage());
        } catch (IOException e) {
            print("Ошибка ввода/вывода: " + e.getMessage());
        }
    }


}
// try{

// }catch (FileNotFoundException e) {
//     print("Файл не найден: " + path);
// } catch (IOException e) {
//     print("Ошибка ввода/вывода: " + e.getMessage());
// } catch (ClassNotFoundException e) {
//     print("Ошибка десериализации: " + e.getMessage());
// }
