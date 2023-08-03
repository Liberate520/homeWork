package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static family_tree.model.human.Gender.Female;
import static family_tree.model.human.Gender.Male;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter=new Presenter(this);
        scanner=new Scanner(System.in);
        work=true;
        menu=new MainMenu(this);
    }

    public void addHuman(){
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        //TODO добавить проверки
        System.out.println("Укажите пол 1 - мужской, 2 - женский");
        String gen = scanner.nextLine();
        int igen = Integer.parseInt(gen);
        Gender gender=null;
        if(igen==1){
            gender= Male;
        }
        if(igen==2){
            gender= Female;
        }

        System.out.println("Укажите год рождения");
        String year = scanner.nextLine();
        int iYear = Integer.parseInt(year);
        System.out.println("Укажите месяц рождения");
        String month = scanner.nextLine();
        int iMonth = Integer.parseInt(month);
        System.out.println("Укажите день рождения");
        String dayOfMonth = scanner.nextLine();
        int iDayOfMonth = Integer.parseInt(dayOfMonth);

        presenter.addHuman(name, gender, LocalDate.of(iYear,iMonth,iDayOfMonth));
    }

    public void wedding(){
        System.out.println("Укажите id мужа");
        String husband = scanner.nextLine();
        //TODO сделать проверку
        long idHusband=Integer.parseInt(husband);
        System.out.println("Укажите id жены");
        String wife = scanner.nextLine();
        long idWife = Integer.parseInt(wife);
        presenter.wedding(idHusband, idWife);

    }

    public void addChildren(){
        System.out.println("Укажите id ребенка");
        String children = scanner.nextLine();
        //TODO сделать проверку
        long idChildren = Integer.parseInt(children);

        System.out.println("Укажите id отца");
        String father = scanner.nextLine();
        long idFather = Integer.parseInt(father);

        System.out.println("Укажите id матери");
        String mother = scanner.nextLine();
        long idMother = Integer.parseInt(mother);

        presenter.addChildren(idChildren, idFather, idMother);
    }
    public void addParents(){
        System.out.println("Укажите id ребенка");
        String children = scanner.nextLine();
        //TODO сделать проверку
        long idChildren = Integer.parseInt(children);

        System.out.println("Укажите id отца");
        String father = scanner.nextLine();
        long idFather = Integer.parseInt(father);

        System.out.println("Укажите id матери");
        String mother = scanner.nextLine();
        long idMother = Integer.parseInt(mother);

        presenter.addChildren(idChildren, idFather, idMother);

    }

    public void finish(){
        work=false;
    }

    public void printInfo(){
        presenter.getHumanListInfo();
    }
    public void readFile(){
        presenter.readFile();
    }

    public void saveFile(){
        presenter.saveFile();
    }

    @Override
    public void start() {
        while (work){
            System.out.println("Здравствуйте");
            System.out.println(menu.menu());
            System.out.println("Выберете пункт меню");
            String choice=scanner.nextLine();
            //TODO добавить проверку

            int choiceInt=Integer.parseInt(choice);
            if( choiceInt > 0 && choiceInt<= menu.getSize()){
                menu.execute(choiceInt);
            }else {
                System.out.println("Вы ввели неверный пункт меню");
            }


        }

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
