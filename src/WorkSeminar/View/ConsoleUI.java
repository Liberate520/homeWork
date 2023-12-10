package WorkSeminar.View;

import WorkSeminar.Presentor.Presentor;
import WorkSeminar.View.CommandsConsol.mainConsole;
import WorkSeminar.model.InputCkeck.ConvertEnter;
import WorkSeminar.model.Persona.Builder.InputID;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private InputsConsole scan;
    private Presentor presentor;
    private boolean cycle;
    private mainConsole menu;
    /*
    Рабочие методы самой UI.
     */
    // Коснтруктор
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        scan = new InputsConsole();
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
    // Показать список персонажей с аказанным именем.
    public void getNamePersona(){
        System.out.println("Введите имя искомого персонажа: ");
        String name = scan.in(scanner);
        presentor.getNamePersona(name);
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
        presentor.creatPerson(scanner);
    }
    // Связать замужеством.
    public void setWedding(){
        System.out.println("Супруг.");
        long personaOne = scan.inID(scanner);
        System.out.println("Супруга.");
        long personaTwo = scan.inID(scanner);
        presentor.Wedding(personaOne, personaTwo);
    }
    // Добавить ребёнку родителей.
    public void addParent(){
        System.out.println("Первый родитель.");
        long personaOne = scan.inID(scanner);
        System.out.println("Второй родитель.");
        long personaTwo = scan.inID(scanner);
        System.out.println("Ребёнок");
        long kid = scan.inID(scanner);
        presentor.Parent(personaOne, personaTwo, kid);
    }
    // Добавить родителю ребёнка.
    public void addKid(){
        System.out.println("Родитель.");
        long personaOne = scan.inID(scanner);
        System.out.println("Ребёнок.");
        long kid = scan.inID(scanner);
        presentor.addKid(personaOne, kid);
    }
    // Установить дату смерти.
    public void setDathday(){
        long persona = scan.inID(scanner);
        System.out.println("Указать дату смерти(yyyy,MM,dd): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy,MM,dd");
        LocalDate date = LocalDate.parse(scan.in(scanner), formatter);//TODO Сделать проверку на валидность
        presentor.setDathday(persona, date);
    }
    public void getSisBroth(){
        System.out.println("Чьих братьев и сестёр ищем. ");
        long personaId = scan.inID(scanner);
        presentor.getSisBroth(personaId);
    }

    public void setPathFile(){
        System.out.println("Введите новый путь файла: ");
        String path = scan.in(scanner);
        presentor.setPathFile(path);
    }
    public void defoldPathFile(){
        presentor.defoldPathFile();
    }
    public void getPathFile(){
        presentor.getPathFile();
    }

}
