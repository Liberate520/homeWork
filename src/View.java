import java.util.Scanner;

public class View {
    private Scanner scan = new Scanner(System.in);
    public int menu(){
        System.out.println("Меню: \n" +
                           "1 - добавление текста\n" +
                           "2 - вывод текста в консоль\n" +
                           "3 - удаление строки\n" +
                           "0 - выход ");
        System.out.print("Ваш выбор: \n");
        String menu = scan.next();
        int menuInt = Integer.parseInt(menu);

        return menuInt;

    }
    public String addTextMenu(){
        System.out.print("Введите ваш текст тут: ");
        String text = scan.next();
        System.out.println("Запись текста...\n" +
                "Ваш текс успешно записан!\n");
        return text;
    }

    public int dellMenu(){
        System.out.print("Введите номер строки для её удаления: ");
        int del = scan.nextInt() - 1;
        int output = del + 1;
        System.out.println("Удаление...\n" +
                           "Строка номер " + output + " успешно удалена\n");
        return del;
    }

    public void messageYourDocument(){
        System.out.println("Ваш документ: ");
    }
}
