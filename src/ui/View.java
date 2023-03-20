package ui;

import java.util.ArrayList;

public interface View {

    // МЕТОДЫ ПОЛЬЗОВАТЕЛЕМ ВАРИАНТА ДЕЙСТВИЙ
    void menu();
    int userDecision();

    // ПРОСМОТР ВСЕХ ЗАПИСЕЙ
    void printAll(String text);

    // ДОБАВЛЕНИЕ НОВОГО ЗАНЯТИЯ
    ArrayList<String> addLesson();
    void addedLesson();

    // УДАЛЕНИЕ ЗАНЯТИЯ ИЗ СПИСКА
    void removeLesson();
    int userChoiceRemove();
    void removeConformation();

    // ИЗМЕНЕНИЕ ДАННЫХ О ЗАНЯТИИ
    void changeLesson();
    int userChange();
    void changeConformation();

    // УВЕДОМЛЕНИЕ О ТОМ, ЧТО В ПЛАНЕ НЕТ ЗАНЯТИЙ
    void emptyStudyPlan();

}