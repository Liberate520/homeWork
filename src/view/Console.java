package view;

import presenter.Presenter;

import java.util.List;
import java.util.Scanner;

import model.tree.classes.Human;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private  boolean work = true;

    public Console() {
        scanner = new Scanner(System.in, "cp866");

    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println("1 - Добавить новую запись\n" +
                    "2 - Вывести все на экран\n" +
                    "3 - Найти человека\n" + 
                    "4 - Завершить работу\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    viewAll();
                    break;
                case "3":
                    Human search = serachPerson();
                    if (search != null){
                        System.out.println(search.toString());
                    }
                    else{
                        System.out.println("Не найдено.");
                    }
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
    private void addPerson(){
        System.out.println("Введите данные нового человека: ");
        Human newHuman = new Human();
        newHuman.setHuman();
        
        boolean loop = false;
        while(!loop){

            System.out.println("Введите данные отца: \n"+
                " 1 - Данные неизвестны \n" + 
                " 2 - Поиск по списку \n");
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    newHuman.setFather(null);
                    loop = true;
                    break;
                case "2":
                    boolean found = false;
                    while (!found){
                        Human father = serachPerson();
                        System.out.println(father != null ? father.toString() : "Не найдено!");
                        System.out.println("Подтвердить выбор?\n" +
                            "1 - Выбрать\n"+
                            "2 - Новый поиск\n"+
                            "3 - Данные неизвестны\n");                       
                        choice = scanner.nextLine();
                        switch(choice){
                            case "1":
                                newHuman.setFather(father);
                                found = true;
                                break;
                            case "2":
                                break;
                            case "3":
                                newHuman.setFather(null);
                                break;
                        }
                    }
                    loop = true;
                    break;
                default:
                    System.out.println("Введите правильно значение!");
                    break;
                }
        }

        loop = false;
        while (!loop){
      
            System.out.println("Введите данные матери: \n"+
            " 1 - Данные неизвестны \n" + 
            " 2 - Поиск по списку \n");
            String choice = scanner.nextLine();
            switch(choice){
            case "1":
                newHuman.setMother(null);
                loop = true;
                break;
            case "2":
                boolean found = false;
                while (!found){
                    Human mother = serachPerson();
                    System.out.println(mother != null ? mother.toString() : "Не найдено!");
                    System.out.println("Подтвердить выбор?\n" +
                        "1 - Выбрать\n"+
                        "2 - Новый поиск\n"+
                        "3 - Данные неизвестны\n");                       
                    choice = scanner.nextLine();
                    switch(choice){
                        case "1":
                            newHuman.setMother(mother);
                            found = true;
                            break;
                        case "2":
                            break;
                        case "3":
                            newHuman.setMother(null);
                            break;
                    }
                }
                loop = true;
                break;
            default:
                System.out.println("Введите правильно значение!");
            }
        }
        presenter.addPerson(newHuman);
    }

    private Human serachPerson(){
        System.out.println("Введите имя для поиска:");
        String name = scanner.nextLine();
        List<Human> matched = presenter.searchPerson(name);
        boolean found = false;
        
        if (matched.size() == 0){
            System.out.println("Совпадений не найдено.");
            return null;
        }
            
        else if (matched.size() == 1){
            return matched.get(0);
        }

        else{
            for (int i = 0; i < matched.size(); i++) {
                System.out.println(i + ": " + matched.get(i).toString());
            }
            while (!found){
                System.out.println("Выберите номер человека или -1 для отмены поиска: ");
                String indexString = scanner.nextLine();
                int indexInt;
                try {
                    indexInt = Integer.parseInt(indexString);
                    if (indexInt >= 0 & indexInt < matched.size()){
                        found = true;
                        return matched.get(indexInt);
                    }
                    else if (indexInt == -1){
                        return null;
                    }
                    else{
                        System.out.println("Ошибка ввода If!");
                    }
                    }
                    catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода Catch!");
                }                
            }           
        }
        return null;        
    }

    private void viewAll(){        
        presenter.printTree();
    }

    private void exit(){
        System.out.println("Работа завершена");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
