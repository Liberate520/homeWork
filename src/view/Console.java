package view;

import java.util.Scanner;
import presenter.Presenter;


public class Console implements View{

        private Scanner scanner;
        private Presenter presenter;
        private Menu menu;
        private boolean work;
    
        @Override
        public void start() {
            scanner = new Scanner(System.in);
            menu = new Menu(this);
            work = true;
            while (work){
                hello();
                String command = scanner.nextLine();
                if (checkInput(command)){
                    menu.execute(Integer.parseInt(command));
                } else {
                    System.out.println("что-то пошло не так");
                }
            }
        }
    
        private boolean checkInput(String text){
            return text.matches("[0-9]+");
        }
    
        private void hello() {
            System.out.println("Программа <<<Семейное дерево V2.0>>>"+"\n");

            System.out.println(menu.printMenu());
        }
    
        @Override
        public void print(String text){
            System.out.println(text);
        }
    
        public void finish(){
            work = false;
        }
    
        
        public void addObject()  {

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String family = scanner.nextLine();
            System.out.print("Введите дату рождения в формате дд.мм.гггг: ");
            String dateBirth = scanner.nextLine();
            System.out.print("Введите имя отца: ");
            String father = scanner.nextLine();
            System.out.print("Введите имя матери: ");
            String mother = scanner.nextLine();
            
            presenter.addObject(name,  family,  dateBirth, father, mother);

        }

       
       // метод для вывода на экран всех объектов семейного дерева
        public void treeView(){
              
          presenter.familyTreeViewAll();
       
        }


        public void Search(){
            System.out.print("Введите имя для поиска объекта: ");
            String name = scanner.nextLine();

            presenter.searchHuman(name);

        }

    
        @Override
        public void setPresenter(Presenter presenter) {
            this.presenter = presenter;
        }
    }

