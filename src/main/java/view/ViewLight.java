package view;

import org.json.JSONException;

public interface ViewLight {
    void start() throws JSONException; //старт программы
    int printMenu(String text); //вывод меню и считывание выбора из меню
    String scanOne(String s); //считывание с теринала одной строки
}
