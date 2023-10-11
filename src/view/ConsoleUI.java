package view;

import presenter.Presenter;

import java.awt.*;
import java.util.Scanner;

public class ConsoleUI implements View {
    private MainMenu menu;
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI()
    {
        menu = new MainMenu( this );
        scanner = new Scanner( System.in );
        presenter = new Presenter( this );
        work = true;
    }

    public void sortByName()
    {
        presenter.sortByName();
    }

    @Override
    public void start() {
        System.out.println("Программа запущена!");
        while ( work )
        {
            System.out.println( menu.menu() );
            execute();
        }
    }

    private void execute() {
        String line = scanner.nextLine();
        if ( checkTextCorrectForInt( line ) )
        {
            int numOption = Integer.parseInt( line );
            if ( checkChosenInput( numOption ) )
            {
                menu.execute( numOption );
            }
            else
            {
                System.out.println("Ошибка выбора опции меню. Попробуйте ещё раз");
            }
        }
    }

    private boolean checkChosenInput(int numOption) {
        return menu.checkChosenInput( numOption );
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println( answer );
    }
    public void finish()
    {
        System.out.println("До свидания.");
        work = false;
    }
    private boolean checkTextCorrectForInt( String text )
    {
        return text.matches("[0-9]+");
    }
}
