package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner in;
    private static String mainMenu = "1 - вывести весь список    " +
                                     "2 - добавить запись    " +
                                     "3 - удалить запись    " +
                                     "8 - load    " +
                                     "9 - save";

    public ConsoleUI() {
        this.in = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            //System.out.print("\033[H\033[J");
            System.out.println("выберите операцию: (0 -> выход)");
            System.out.println(mainMenu);
            String key = inputParam();
            if (key.equals("0")) break;
            if (key.equals("1")) presenter.showAll();
            if (key.equals("2")) {
                System.out.println("введите текст");
                String text = inputParam();
                System.out.println("введите срок");
                String dl = inputParam();
                presenter.addRec(new String[]{text, dl});
            }
            if (key.equals("3")) {
                presenter.showAll();
                System.out.println("введите номер записи (0 -> выход)");
                String id = inputParam();
                if (id.equals("0")) continue;
                presenter.delRec(id);
            }
            if (key.equals("8")) {
                presenter.load();
                presenter.showAll();
            }
            if (key.equals("9")) presenter.save();

        }
    }

    private String inputParam() {
        while (!in.hasNext()) in.next();
        return in.nextLine();
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
