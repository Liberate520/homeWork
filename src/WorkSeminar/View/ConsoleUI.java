package WorkSeminar.View;

import WorkSeminar.Presentor.Presentor;
import WorkSeminar.View.CommandsConsol.mainConsole;


import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presentor presentor;
    private boolean cycle;
    private mainConsole menu;

    // Коснтруктор
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presentor = new Presentor(this);
        cycle = true;
        menu = new mainConsole(this);
    }
    // Запуск приложения.
    @Override
    public void start() {
        while (cycle){
            catalogCommand();
            consoleWork();
        }
        scanner.close();
    }
    // Метод ответа.
    @Override
    public void aswer(String answer) {
        System.out.println(answer);
    }
    // Печать списка комманд.
    private  void catalogCommand(){
        System.out.println(menu.print());
    }
    // Запрос на ввод комманд.
    private void consoleWork(){
        String enter = scanner.nextLine();
        //Сделать проверку на число.
        int enterTrue = Integer.parseInt(enter);
        menu.execute(enterTrue);
    }

    public void createTree(){
        presentor.creatTree();
    }
    public void showTree(){
        presentor.showTree();
    }
    public void sortTreeByAge(){
        presentor.sortTreeByAge();
    }
    public void sortDefaut(){
        presentor.sortDefaut();
    }
    public void sortTreeByGender(){
        presentor.sortTreeByGender();
    }
    public void seveTree(){
        presentor.saveTree();
    }
    public void loadTree(){
        presentor.loadTree();
    }
    public void endWork(){
       cycle = presentor.exit();
    }

}
