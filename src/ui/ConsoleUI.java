package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View{

    private Presenter presenter;
    private Scanner scanner;
    private HashMap<String, String> data;
    

    public ConsoleUI() {
        scanner = new Scanner(System.in, "CP866");
        data = new HashMap<String, String>();
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        while (0<1) {
            presenter.onClick(menu());
        }
    }

    @Override
    public HashMap<String, String> menu() {
        data.put("selector", "");
        while(data.get("selector") != "0"){
            System.out.println("~~~~~~~~~~" + 
            "\n1. Показать семейное древо."+
            "\n2. Найти человека по имени."+
            "\n3. Добавить человека."+
            "\n0. Выйти.");
            data.put("selector", scan());
            if (data.get("selector").equals("1")){
                data.put("selector", "full");
                return data;
            }
            else if(data.get("selector").equals("2")){
                data.put("selector", "search");
                System.out.println("Введит имя: ");
                data.put("name", scanner.next());
                System.out.println("Введит фамилию: ");
                data.put("surname", scanner.next());
                return data;
            }
            else if(data.get("selector").equals("3")){
                data.put("selector", "add");
                return сompleteDatEntry(data);
            }
            else if(data.get("selector").equals("0")){
                System.exit(0);
            }
            else{
                System.out.println("Не верное значение.");
            }
        }
        return data;
    }

    private String scan() {
        System.out.println("Введит значение: ");
        return scanner.nextLine();
    }

    private HashMap<String, String> сompleteDatEntry(HashMap<String, String> user){
        System.out.println("Введит имя: ");
        user.put("name", scanner.next());
        System.out.println("Введит фамилию: ");
        user.put("surname", scanner.next());
        System.out.println("Введит пол (Male, Female): ");
        user.put("sex", scanner.next());
        System.out.println("Введит год рождения: ");
        user.put("startDate", scanner.next());
        System.out.println("Введит год ухода: ");
        user.put("endDate", scanner.next());
        System.out.println("Введит имя матери: ");
        user.put("nameMother", scanner.next());
        System.out.println("Введит фамилию матери: ");
        user.put("surnameMother", scanner.next());
        System.out.println("Введит имя отца: ");
        user.put("nameFather", scanner.next());
        System.out.println("Введит фамилию отца: ");
        user.put("surnameFather", scanner.next());

        return user;
    }

    @Override
    public void print(String data) {
        System.out.println(data);
    }


    
}
