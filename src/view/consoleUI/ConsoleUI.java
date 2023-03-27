package view.consoleUI;

import presenter.Presenter;
import view.View;
import view.consoleUI.commands.*;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.SimpleMenu;

import java.util.Scanner;

/**
 * Класс, отвечающий за консольный интерфейс
 */
public class ConsoleUI implements View {
    public static Scanner scanner;
    public static Presenter presenter;
    public static Notifier notifier;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        notifier = new Notifier();
    }

    public void setPresenter(Presenter presenter) {
        ConsoleUI.presenter = presenter;
    }

    public void start() {
        //noinspection InfiniteLoopStatement
        while (true) {

            // Цикл для создания стартового меню, когда файл не открыт
            SimpleMenu startSimpleMenu = new SimpleMenu("Стартовое меню", true);
            startSimpleMenu.addCommand(new CreateFile());
            startSimpleMenu.addCommand(new CreateFileOpeningMenu());
            startSimpleMenu.addCommand(new Exit());
            startSimpleMenu.run();

            if (presenter.fileIsOpened() && presenter.isUnsaved()){
                SimpleMenu askBeforeClose = new SimpleMenu("Имеются не сохраненные изменения. Сохранить перед выходом?", false);
                askBeforeClose.addCommand(new Command() {
                    @Override
                    public String getDescription() {
                        return "Да";
                    }

                    @Override
                    public void execute(Menu menu) {
                        new SaveFile().execute(menu);
                    }
                });
                askBeforeClose.addCommand(new Command(){
                    @Override
                    public String getDescription() {
                        return "Нет";
                    }

                    @Override
                    public void execute(Menu menu) {
                        menu.stop();
                    }
                });
                askBeforeClose.run();
            } else {
                presenter.resetNotepad();
            }
        }
    }
}
