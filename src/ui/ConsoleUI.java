package ui;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View
{
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    public void start() throws IOException, ClassNotFoundException {

        System.out.printf("\nВас приветствует электронная версия генеалогического древа династии Романовых!\n");

        while(true)
        {
            String stringToParse = scan();

            if (userExit(stringToParse))
            {
                System.out.println("До свидания!");
                return;
            }

            presenter.onClick(stringToParse);
        }
    }

    private boolean userExit(String stringToParse)
    {
        boolean result = false;
        if (stringToParse.equals("0"))
        {
            result = true;
        }
        return result;
    }

    private String scan() {
        System.out.println("Введите номер меню:");
        System.out.printf("\t0 выход из программы;\n");
        System.out.printf("\t1 печать информации о детях представителя династии;\n");
        System.out.printf("\t2 печать информации о всех представителях династии;\n");
        System.out.printf("\t3 печать информации о всех представителях династии с помощью Iterable;\n");
        System.out.printf("\t4 отсортировать династию по именам;\n");
        System.out.printf("\t5 отсортировать династию по году рождения;\n");
        System.out.printf("\t6 Сохранить информацию с помощью serialize;\n");
        System.out.printf("\t7 Восстановить информацию с помощью serialize.\n");
        System.out.printf("> ");

        return scanner.nextLine();
    }

    public void print(String text) {
        System.out.printf("%s",text);
    }
}
