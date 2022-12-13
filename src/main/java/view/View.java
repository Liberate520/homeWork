package view;

public interface View extends ViewLight {
    String scanOther(String s); //считывание нескольких строк
    void printStr(String s); //вывод текста
}
