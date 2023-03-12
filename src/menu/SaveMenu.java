package menu;

import java.util.Scanner;

import ui.View;

public class SaveMenu  extends Command{
    private Scanner scanner;
    
    public SaveMenu(View view) {
        super(view);
        scanner = new Scanner(System.in);
    }

    @Override
    public String description() {
        // TODO Auto-generated method stub
        return "Запись в файл";
    }

    @Override
    public int execute() {
        Integer chois;
        this.getView().showAllPerson();
        this.getView().print("\nВыберете пункт меню:\n");
        this.getView().print("\n1. Сохранение\n2. Отмена");
        chois=scanner.nextInt();
        if (chois==0) return 30;
        return 30+chois;
    }
}
