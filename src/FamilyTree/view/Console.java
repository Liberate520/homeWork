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
        print("Консоль готова к работе");
    }


    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        
        while (work) {
            print("---------------------------------------------------\n" +
                    "1 - добавить новую запись\n" +
                    "2 - вывести все на экран\n" +
                    "3 - показать подробную информацию о записи\n" +
                    "4 - удалить запись из дерева\n" +
                    "5 - завершить работу");
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
                    showNodeInfo();
                    break;
                case "4":
                    deleteNode();
                    break;
                case "5":
                    exit();
                    break;    
                default:
                    print("Ошибка ввода");
            }
        }
    }

    @Override
    public void askAndAnswer(String question) {
        System.out.print(question);//тут нужен именно принт, без перевода на новую строку
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


    @Override
    public void showNodeInfo() {
        print("Введите текст для поиска человека: ");
        String search = scanner.nextLine();
        String result = presenter.findNodes(search);
        if(result.equals("")){
            print("Ничего не найдено!");
        }else{
            print(result);
            System.out.print("Введите номер записи: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            presenter.showNodeFullInfo(index-1);//коррекция индекса на -1, тк спискок с 1, а лист с 0
        }
    }

    public void deleteNode() {
        viewAll();//пока выводить список всех записей. потом продумать как у найденных сохранять исходный индекс в дереве
        print("Введите номер записи: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        presenter.deleteNode(index-1);
    }

}

