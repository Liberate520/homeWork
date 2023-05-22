package ui;

import presenter.Presenter;

import java.util.Scanner;

public abstract class ConsoleMenu implements View {
    static final String INPUT_ERROR = "Вы ввели неверное значение, повторите ввод";

    Presenter presenter;

    Scanner scanner;

    boolean start;

    @Override
    public abstract void start();

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void finish() {
        start = false;
    }

    boolean checkCommand(int numCommand, Menu menu){
        if (numCommand <= menu.size() && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    void inputError() {
        System.out.println(INPUT_ERROR);
    }

}
