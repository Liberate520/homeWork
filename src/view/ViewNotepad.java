package view;
import presenter.PresenterNotepad;
import java.io.IOException;
import java.util.Scanner;

public class ViewNotepad {
    private PresenterNotepad presenterNotepad;
    private Scanner scanner;

    public ViewNotepad() {
        this.scanner = new Scanner(System.in);
    }

    public void setPresenter(PresenterNotepad presenterNotepad) {
        this.presenterNotepad = presenterNotepad;
    }

    public int menu() throws IOException {
        System.out.println("Выберите необходимый пункт меню:\n");
        System.out.println("1. Создать запись в блокноте\n");
        System.out.println("2. Показать все записи в блокноте\n");
        System.out.println("3. Выход\n");
        while (true) {
            System.out.print("Ваш ответ: \n");
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                if (answer >= 1 && answer <= 3) {
                    presenterNotepad.onClick(answer);
                    System.out.println();
                    return answer;
                } else System.out.println("Введите число от 1 до 3");
            }else {
                System.out.println("Введите число от 1 до 3");
                scanner.next();
            }
        }
    }
}
