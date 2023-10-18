package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
   private MainMenu menu;
   private Scanner scanner;
   private Presenter presenter;
   private boolean work;
   private static final String Input_Error =  "Неверное значение";

   public ConsoleUI() {
      menu = new MainMenu(this);
      scanner = new Scanner(System.in);
      presenter = new Presenter(this);
      work = true;
   }

   @Override
   public void print(String text) {
      // TODO Auto-generated method stub
      System.out.println(text);
   }

   @Override
   public void start() {
      hello();
      while (work) {
         printMenu();
         execute();
      }
   }

   public void finish() {
      System.out.println("Заходите!");
      work = false;
   }

   public void sortByName() {
      presenter.sortByName();
   }

   public void sortBirthDay() {
      presenter.sortBirthDay();
   }

   public void getHumanList() {
      presenter.getHumanList();
   }

   public void addHuman() {
      System.out.println("Введите имя человека");
      String name = scanner.nextLine();
      System.out.println("Укажите возраст человека");
      String strAge = scanner.nextLine();
   }

   private void hello(){
      System.out.println("Hello");
   }
   private void execute(){
      String line = scanner.nextLine();
      if(checkTextForInt(line)){
         int numCommand = Integer.parseInt(line);
         if(checkCommand(numCommand)){
            menu.execute(numCommand);
         }
      }
   }
   private boolean checkTextForInt(String text){
      if (text.matches("[0-9]+")){
         return true;
      }else {
         inputError();
         return false;
      }
   }
   private boolean checkCommand(int numCommand){
      if (numCommand < menu.getSize()){
         return true;
      }else{
         inputError();
         return false;
      }
   }
   private void printMenu(){
      System.out.println(menu.menu());
   }
   private void inputError(){
      System.out.println(Input_Error);
   }


}
