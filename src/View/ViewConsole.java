package View;

import Presenter.Presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ViewConsole extends View{
    private String name;
    private String surname;
    private String gender;
    private int command;
    private Presenter presenter;
    private Boolean flag = true;
    private Scanner scanner = new Scanner(System.in);
    private String[]commands = new String[]{"0 - выход", "1 - добавить", "2 - удалить", "3 - добавить родителя", "4 - добавить потомка", "5 - получить информацию", "6 - вывести информацию по всем"};
    @Override
    public void start() {


        while(flag){

            for (int i = 0; i < commands.length; i++){
                System.out.println(commands[i]);
            }
            command = scanner.nextInt();
            scanner.nextLine();
            name = "";
            surname = "";
            gender = "";
            if(command == 1){
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surname = scanner.nextLine();
                System.out.println("Введите пол");
                gender = scanner.nextLine();
                presenter.addObject(name,surname, gender);
            }
            if(command == 2){
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surname = scanner.nextLine();
                if (presenter.deleteObject(name, surname)== false){
                    System.out.println("Объект не найден");
                }
            }
            if(command == 3){
                System.out.println("Укажите кому хотите добавить родителя");
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surname = scanner.nextLine();
                if (presenter.getObject(name, surname)== null){
                    System.out.println("Объект не найден");
                }
                else {System.out.println("Укажите данные родителя");
                    System.out.println("Введите имя");
                    name = scanner.nextLine();
                    System.out.println("Введите фамилию");
                    surname = scanner.nextLine();
                    System.out.println("Введите пол");
                    surname = scanner.nextLine();
                    presenter.addParent(presenter.getObject(name, surname), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());}

            }
            if(command == 5){
                System.out.println("Укажите кому хотите добавить потомка");
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surname = scanner.nextLine();
                if (presenter.getObject(name, surname)== null){
                    System.out.println("Объект не найден");
                }
                else {System.out.println("Укажите данные потомка");
                    System.out.println("Введите имя");
                    name = scanner.nextLine();
                    System.out.println("Введите фамилию");
                    surname = scanner.nextLine();
                    System.out.println("Введите пол");
                    surname = scanner.nextLine();
                    presenter.addParent(presenter.getObject(name, surname), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());}

            }
            if(command == 5){
                System.out.println("Введите имя");
                name = scanner.nextLine();
                System.out.println("Введите фамилию");
                surname = scanner.nextLine();
                if(presenter.objectInfo(name, surname)!=null){
                    System.out.println(presenter.objectInfo(name, surname));
                }
                else{
                    System.out.println("Объект не найден");
                }

            }
            if(command == 6){
                System.out.println(presenter.allObjectInfo());
            }
            if (command == 0){
                flag = false;
            }



        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
