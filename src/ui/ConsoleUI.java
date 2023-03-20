package ui;


import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View{
    private final Scanner sc;

    public ConsoleUI() {
        this.sc = new Scanner(System.in);
    }

    // ПЕЧАТЬ МЕНЮ
    @Override
    public void menu() {
        System.out.print("""
                
                МЕНЮ ПРОГРАММЫ:\s
                Показать содержание ежедневника  - нажмите 1
                Добавить запись                  - нажмите 2
                Удалить запись                   - нажмите 3
                Изменить запись                  - нажмите 4
                Выход из программы               - нажмите 5
                Укажите Ваше решение:\s""");
    }

    public int userDecision(){
        return sc.nextInt();
    }

    // ВЫВОД НА ПЕЧАТЬ ПЛАНА ЗАНЯТИЙ
    @Override
    public void printAll(String text) {
        System.out.println(text);
    }

    // ДОБАВЛЕНИЕ НОВОГО ЗАНЯТИЯ
    @Override
    public ArrayList<String> addLesson() {
        ArrayList<String> newLesson = new ArrayList<>();
        System.out.println("\nДобавление урока в расписание: ");
        sc.nextLine();

        System.out.print("Наименование предмета: ");
        String subject = sc.nextLine();
        newLesson.add(subject);

        System.out.print("Тип занятия: ");
        String lessonType = sc.nextLine();
        newLesson.add(lessonType);

        System.out.print("Укажите имя и фамилию преподавателя: ");
        String teacherName = sc.nextLine();
        newLesson.add(teacherName);

        System.out.print("Тема урока: ");
        String lessonTopic = sc.nextLine();
        newLesson.add(lessonTopic);

        System.out.print("Дата проведения: ");
        String lessonData = sc.nextLine();
        newLesson.add(lessonData);

        System.out.print("Время начала: ");
        String beginningTime = sc.nextLine();
        newLesson.add(beginningTime);

        System.out.print("Примечания: ");
        String description = sc.nextLine();
        newLesson.add(description);

        return newLesson;
    }

    public void addedLesson(){
        System.out.println("\nСведения о занянии добавлены в учебный план.\n");
    }


    // УДАЛЕНИЕ ЗАНЯТИЙ ИЗ ПЛАНА
    public void removeLesson(){
        System.out.print("\nВведите номер занятия, которое хотите удалить: ");
    }

    public int userChoiceRemove(){
        return sc.nextInt();
    }

    public void removeConformation(){
        System.out.println("\nДанные о занятии удалены.\n");
    }

    // ИЗМЕНЕНИЕ ДАННЫХ О ЗАНЯТИИ
    public void changeLesson() {
        System.out.print("\nВведите номер занятия, которое хотите изменить: ");
    }
    public int userChange() {
        return sc.nextInt();
    }
    public void changeConformation(){
        System.out.println("\nДанные о занятии изменены.\n");
    }

    // УВЕДОМЛЕНИЕ ОБ ОТСУТСВИИ ЗАНЯТИЙ В ПЛАНЕ
    public void emptyStudyPlan(){
        System.out.println("\nВ учебном плане нет занятий.\n");
    }
}