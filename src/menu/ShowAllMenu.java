package menu;

import java.util.Scanner;

import ui.View;

public class ShowAllMenu  extends Command{
    private Scanner scanner;
    
    public ShowAllMenu(View view) {
        super(view);
        scanner = new Scanner(System.in);
    }

    @Override
    public String description() {
        return "Работа со списком";
    }

    @Override
    public int execute() {
        // TODO Auto-generated method stub
        
        Integer chois;
        this.getView().showAllPerson();
        this.getView().print("\nВыберете пункт меню:\n");
        this.getView().print("\n1. Сортировка по имени\n2. Сортировка по году рождения\n3. Выход");
        chois=scanner.nextInt();
        if (chois==0) return 20;
        System.out.println("cur ---- " +chois);
        return 20+chois;
    }
    
}
