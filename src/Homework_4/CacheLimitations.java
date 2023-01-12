package Homework_4;

import java.util.ArrayList;
import java.util.List;

public class CacheLimitations<T> { //Класс для кеширования списков

    ArrayList<T> el;
    int size;

    public CacheLimitations(int size) {
        this.size = size;
        el = new ArrayList<>(); //создаем экземпляр

    }

    public void addEl(T El) { //метод добавления элемента
        int curSize = el.size(); //текущий размер
        if (curSize >= size) {
            for (int i = 0; i < curSize - size + 1; i++) {
                el.remove(0);//при переполнение кэша удаляем более старые записи
            }
            el.add(El); //добавляем в конец
        }


    }

    public T getEl(int i) { //получаем элемент списка под номером
        if (i >= el.size()) {
            return null;
        }
        return el.get(i); //вернем нужный элемент.
    }

    public List<T> getAllEL() { ////получаем все элементы списка
        return el;

    }
}
