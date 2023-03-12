package menu;

import java.util.Scanner;

import ui.View;

public class LoadMenu  extends Command{
    private Scanner scanner;
    
    public LoadMenu(View view) {
        super(view);
        scanner = new Scanner(System.in);
    }

    @Override
    public String description() {

        return "Чтение из файла";
    }

    @Override
    public int execute() {
        Integer chois;
        this.getView().showAllPerson();
        this.getView().print("\nВыберете пункт меню:\n");
        this.getView().print("\n1. Чтение\n2. Отмена");
        chois=scanner.nextInt();
        if (chois==0) return 40;
        return 40+chois;
    }
    
}
