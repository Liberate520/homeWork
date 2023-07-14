package homeWork.FamalyTree.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import homeWork.FamalyTree.model.Human.Gender;
import homeWork.FamalyTree.presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        work = true;
        }
    
    @Override
    public void print(String text){
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Привет");
        while (work){
            System.out.println(menu.menu());
            execute();
        }
    }

    public void addHuman(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String last_name = scanner.nextLine();
        System.out.println("Введите дату рождения (в формате YYYY-MM-DD): ");
        String DOBString = scanner.nextLine();
        LocalDate DOB = LocalDate.parse(DOBString);
        System.out.println("Введите дату смерти (в формате YYYY-MM-DD). Если обьект жив прописать - нет: ");
        String DODString = scanner.nextLine();
        if (DODString.toLowerCase() != "нет"){LocalDate DOD = LocalDate.parse(DODString);}
        else{LocalDate DOD = null;}
        System.out.println("Введите пол в фомате м/ж: ");
        String genderString = scanner.nextLine();
        if (genderString.toLowerCase() == "м"){Gender gender = Gender.Male;}
        else{Gender gender = Gender.Female;}
        System.out.println("Введите имя отца. Если информация отсутствует прописываем - нет: ");
        String fatherString = scanner.nextLine();
        if (fatherString.toLowerCase() != "нет"){String father = fatherString;}
        else{String father = null;}
        System.out.println("Введите имя матери. Если информация отсутствует прописываем - нет: ");
        String motherString = scanner.nextLine();
        if (motherString.toLowerCase() != "нет"){String mother = motherString;}
        else{String mother = null;}
        System.out.println("Введите имена детей через запятую. Если информация отсутствует прописываем - нет: ");
        String childrenString = scanner.nextLine();
        List<String> children = new ArrayList<>();
        if (childrenString.toLowerCase() != "нет"){            
            if (childrenString.contains(",")){
                String[] arr = childrenString.split(", ");
                for (int i = 0; i < arr.length; i++) {
                    children.add(arr[i]);
                }                           
            }
            else{children.add(childrenString);}
        }
        else{children = null;}

        presenter.addHuman(name, last_name, DOB, DOD, gender, father, mother, children);
    }

    public void getHumanInfo(){
        presenter.getHumanInfo();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void finish(){
        System.out.println("До скорой встречи");
        work = false;
    }

    private void execute() {
        String line = scanner.nextLine();
        if (numberForMenu(line)){
            int num = Integer.parseInt(line);
            if (checkCommand(num)){
                menu.execute(num);
            }
        }
    }

    private boolean checkCommand(int num) {
        if (num < menu.getSize()){
            return true;
        }
        else {
            inputError();
            return false;
        }
    }

    private boolean numberForMenu(String text) {
        if (text.matches("[0-9]+")){
            return true;
        }
        else{
        inputError();
        return false;
    }
    }

    private void inputError() {
        System.out.println("Введено неверное зачение");
    }
}
