package menu;

import java.util.Scanner;

import ui.View;

public class StartMenu  extends Command{
    private Scanner scanner;
    
    public StartMenu(View view) {
        super(view);
        scanner = new Scanner(System.in);
    }

    @Override
    public String description() {
        return "Начальное меню ";
    }

    @Override
    public int execute() {
        Integer chois;

            this.getView().print("\nВыберете пункт меню:\n");
            this.getView().print("\n1. Редактирование персонажа\n2. Информация о всех персонажах\n3. Запись в файл\n4. Чтение из файла(если файла нет грузятся тестовые данные)\n0. Выход");
            chois=scanner.nextInt();
            System.out.println("cur ---- " +chois);
        return chois;
    }
    
}
