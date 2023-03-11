package ui;

import presenter.Presenter;

public interface View {
    
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);

    // public View() {
    // }

    // public int menu() {
    //     try {
    //     Scanner scan = new Scanner(System.in);
    //     System.out.println("""
    //                     *** MENU ***        
    //             Выберите нужный пункт:
    //             1 - Вывести весь список;
    //             2 - Сортировать по алфавиту;
    //             3 - Сортировка по годам;
    //             4 - Поиск по имени и фамилии;
    //             5 - Добавить нового человека;
    //             6 - Сохранить изменения;
    //             0 - Завершить работу.   """);
    //         int num = scan.nextInt();
    //         return num;
    //     } catch (Exception e) {
    //         System.out.println("Oops!..");
    //         return menu();
    //     }
    // }
}
