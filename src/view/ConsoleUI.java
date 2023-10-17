package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
   private MainMenu mainMenu;
   private Scanner scanner;
   private Presenter presenter;
   private boolean work;
    

   public ConsoleUI(){
      mainMenu = new MainMenu(this);
      scanner = new Scanner(System.in);
      presenter = new Presenter(null);
      work = true;
   }

   @Override
   public void print(String text) {
      // TODO Auto-generated method stub
      System.out.println(text);
   }

   @Override
   public void start() {
      System.out.println("Hello");
      // TODO Auto-generated method stub
      while (work){
         System.out.println(mainMenu.menu());
         String line = scanner.nextLine();
         int choice = Integer.parseInt(line);
         mainMenu.choice(choice);
      }
         
   }
   public void finish(){
      work = false;
   }

   public void sortByName(){
      presenter.sortByName();
  }
   public void sortBirthDay(){
      presenter.sortBirthDay();
   }
   public void getHumanList(){
      presenter.getHumanList();
   }
  public void addHuman(){
      System.out.println("Введите имя человека");
      String name = scanner.nextLine();
      System.out.println("Укажите возраст человека");
      String strAge = scanner.nextLine();
   }
  
   
}            
















































































































































































































































































































































         

