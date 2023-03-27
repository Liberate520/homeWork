package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter; //связь с презентером
    private Scanner scanner;
    private boolean flag;

    /**
     * Конструктор запускает сканер
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    /**
     * указание с каким презентером мы хотим работаем
     * @param presenter
     */
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    /**
     * Здесь начинается программа
     */
    @Override
    public boolean start(){
        this.flag = true;
        presenter.getMenu();
        String commandNumber = scan("Введите команду: "); // сканируем информацию от пользователя
        presenter.getAnswer(commandNumber); //пересылаем комманду в презентер
        return flag;
    }

    private String scan(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    /**
     * Используется чтобы вернуть информацию во view
     * сюда поступает ответ от модели и мы его выводим в консоль
     * @param text - ответ от модели
     */
    @Override
    public void print(String text){
        System.out.println(text);
    }

    @Override
    public void newNote() {
        String note = scan("Введите текст заметки: ");
        presenter.createNote(note);
    }
    public void changeFlag(){
        this.flag = presenter.getFlag();
    }
}
