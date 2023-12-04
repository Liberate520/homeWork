package WorkSeminar.View;

import WorkSeminar.Presentor.Presentor;
import WorkSeminar.View.CommandsConsol.mainConsole;
import WorkSeminar.model.InputCkeck.ConvertEnter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presentor presentor;
    private boolean cycle;
    private mainConsole menu;
    /*
    Рабочие методы самой UI.
     */
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
    // Оставить как внутренний метод UI?
    private void consoleWork(){
        System.out.println("Ввод команды: ");
        String enterConsol = scanner.nextLine();
        ConvertEnter converEnter = new ConvertEnter(enterConsol, menu.size());
        Integer enterTrue = converEnter.convertEnter();
        if(enterTrue != null){
            menu.execute(enterTrue);
        }
    }
    /*
    Методы древа.
     */
    // Создание тестовго древа с заданными параметрами.
    public void createTree(){
        presentor.creatTree();
    }
    // Показать текущее древо.
    public void showTree(){
        presentor.showTree();
    }
    // Сортировка по имени.
    public void sortTreeByName(){
        presentor.sortTreeByName();}
    // Отсортировать древо по возрасту. От младшего к стершему.
    public void sortTreeByAge(){
        presentor.sortTreeByAge();
    }
    // Отсортировать древо по возрасту. От старшего к младшему.
    public void sortDefaut(){
        presentor.sortDefaut();
    }
    //Отсортировать древо по гендору. От девочки - мальчики.
    public void sortTreeByGender(){
        presentor.sortTreeByGender();
    }
    //Сохранить древо.
    public void seveTree(){
        presentor.saveTree();
    }
    //Загрузить сохранёное древо.
    public void loadTree(){
        presentor.loadTree();
    }
    //Завершить работу.
    public void endWork(){
       cycle = presentor.exit();
    }
    // Создать человека через консоль.
    public void creatPersona(){
        presentor.creatPerson();
    }
    // Связать замужеством.
    public void setWedding(){
        presentor.setWedding();
    }
    // Добавить ребёнку родителей.
    public void addParent(){
        presentor.addParent();
    }
    // Добавить родителю ребёнка.
    public void addKid(){
        presentor.addKid();
    }

}
